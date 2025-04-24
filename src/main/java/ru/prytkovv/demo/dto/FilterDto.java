package ru.prytkovv.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FilterDto {
        OffsetDateTime from;
        OffsetDateTime till;
        Long startId;
        Boolean asc = true;
        Integer limit = 10;
        Integer offset = 0;
}
