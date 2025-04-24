package ru.prytkovv.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.prytkovv.demo.dto.FilterDto;
import ru.prytkovv.demo.dto.ProductDto;
import ru.prytkovv.demo.service.ProductService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(ProductController.URL)
@RequiredArgsConstructor
public class ProductController {

    public static final String URL = "/api/v1/products";
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> readAll(@ModelAttribute FilterDto filter) {
        return productService.getAll(filter);
    }

    @GetMapping("/{id}")
    public ProductDto read(@PathVariable("id") Long id) {
        return productService.get(id);
    }
}
