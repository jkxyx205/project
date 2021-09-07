package com.rick.project.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.rick.db.dto.Grid;
import lombok.experimental.UtilityClass;

/**
 * @author Rick
 * @createdAt 2021-03-24 01:05:00
 */
@UtilityClass
public class GridFormatterUtils {

    /**
     * 苞米豆GridService.java
     * @param page
     * @return Grid<T>
     */
    public static <T> Grid<T> of(Page<T> page) {
        Grid<T> grid = Grid.<T>builder()
                .totalPages(page.getPages())
                .page((int)page.getCurrent())
                .rows(page.getRecords())
                .pageSize((int)page.getSize())
                .records(page.getTotal())
                .build();
        return grid;
    }

    /**
     * pagehelper
     * @param pageInfo
     * @return Grid<T>
     */
    public static <T> Grid<T> of(PageInfo<T> pageInfo) {
        Grid<T> grid = Grid.<T>builder()
                .totalPages(pageInfo.getPages())
                .page(pageInfo.getPageNum())
                .rows(pageInfo.getList())
                .pageSize(pageInfo.getPageSize())
                .records(pageInfo.getTotal())
                .build();
        return grid;
    }

    /**
     * jpa
     * @param page
     * @return Grid<T>
     */
//    public static <T> Grid<T> of(Page<T> page) {
//        Grid<T> grid = Grid.builder().totalPages(page.getTotalPages())
//                .page(page.getNumber() + 1)
//                .rows(page.getContent())
//                .pageSize(page.getSize())
//                .records(page.getTotalElements())
//                .build();
//        return grid;
//    }
}
