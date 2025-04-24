package ru.prytkovv.demo.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.prytkovv.demo.dto.FilterDto;
import ru.prytkovv.demo.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;
import static ru.prytkovv.model.Tables.PRODUCT;
import static ru.prytkovv.model.Tables.PRODUCT_TAG;
import static ru.prytkovv.model.Tables.TAG;


@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class ProductService {

    private final DSLContext context;

    public List<ProductDto> getAll(FilterDto filter) {
        var selections = context.select(
                PRODUCT.ID,
                PRODUCT.CATEGORY_ID,
                multiset(
                        select(PRODUCT_TAG.tag().NAME).from(PRODUCT_TAG)
                                .join(TAG).on(PRODUCT_TAG.TAG_ID.eq(TAG.ID))
                                .where(PRODUCT_TAG.PRODUCT_ID.eq(PRODUCT.ID))
                ).as("tags").convertFrom(r -> r.map(record -> record.get("name", String.class))),
                PRODUCT.CREATED_AT);
        List<Condition> predicates = new ArrayList<>();
        predicates.add(PRODUCT.CREATED_AT.between(filter.getFrom(), filter.getTill()));
        if (filter.getStartId() != null) {
            predicates.add(filter.getAsc()
                    ? PRODUCT.ID.greaterThan(filter.getStartId())
                    : PRODUCT.ID.lessThan(filter.getStartId()));
        }
        var from = selections.from(PRODUCT);
        var order = filter.getAsc() ? PRODUCT.CREATED_AT.asc() : PRODUCT.CREATED_AT.desc();
        var query = from.where(predicates).orderBy(order).limit(filter.getLimit()).offset(filter.getOffset());
        return query.fetchInto(ProductDto.class);
    }

    public ProductDto get(Long id) {
        return context.select(
                PRODUCT.ID,
                PRODUCT.CATEGORY_ID,
                multiset(
                        select(PRODUCT_TAG.tag().NAME).from(PRODUCT_TAG)
                                .join(TAG).on(PRODUCT_TAG.TAG_ID.eq(TAG.ID))
                                .where(PRODUCT_TAG.PRODUCT_ID.eq(PRODUCT.ID))
                ).as("tags").convertFrom(r -> r.map(record -> record.get("name", String.class))),
                PRODUCT.CREATED_AT
        ).from(PRODUCT).where(PRODUCT.ID.eq(id)).fetchOneInto(ProductDto.class);
    }
}
