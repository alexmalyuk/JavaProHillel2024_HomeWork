package com.ordersApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class PageResponseDto<T> {
    private List<T> content;
    private int page;
    private int size;
    private long totalRecords;
    private long totalPages;
}
