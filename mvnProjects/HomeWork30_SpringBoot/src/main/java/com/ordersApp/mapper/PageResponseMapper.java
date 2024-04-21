package com.ordersApp.mapper;

import com.ordersApp.dto.PageResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

@Slf4j
public class PageResponseMapper<T> {
    public PageResponseDto<T> shrink(Page<T> page) {
        log.info("call shrink");
        return new PageResponseDto<T>()
                .setContent(page.getContent())
                .setPage(page.getNumber())
                .setSize(page.getSize())
                .setTotalRecords(page.getTotalElements())
                .setTotalPages(page.getTotalPages());
    }
}
