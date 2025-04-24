package ru.prytkovv.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.OffsetDateTime;
import java.util.List;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductDto(
    Long id,
    Integer categoryId,
    List<String> tags,
    OffsetDateTime createdAt
) {}
