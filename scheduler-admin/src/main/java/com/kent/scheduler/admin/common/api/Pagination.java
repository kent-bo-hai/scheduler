package com.kent.scheduler.admin.common.api;

import java.util.List;

/**
 * @author kent on 2017/10/14.
 */
public final class Pagination<T> {

    private static final int MIN_PAGE_NUM = 1;
    private static final int MIN_PAGE_SIZE = 0;
    private static final int MAX_PAGE_SIZE = 5000;

    private final int pageNum;
    private final int pageSize;
    private int total;
    private int offset;
    private List<T> data;


    private Pagination(int pageNum, int pageSize) {
        if (pageNum < MIN_PAGE_NUM) {
            pageNum = MIN_PAGE_NUM;
        }
        if (pageSize < MIN_PAGE_SIZE) {
            pageSize = MIN_PAGE_SIZE;
        }
        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    private Pagination(int pageNum, int pageSize, int total, List<T> data) {
        this(pageNum, pageSize);
        this.total = total;
        this.data = data;
    }

    public static Pagination of(int pageNum, int pageSize) {
        return new Pagination(pageNum, pageSize);
    }

    public static <T> Pagination<T> of(int pageNum, int pageSize, int total, List<T> data) {
        return new Pagination<>(pageNum, pageSize, total, data);
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getOffset() {
        return (pageNum - 1) * pageNum;
    }

    public int getTotal() {
        return total;
    }

    public List<T> getData() {
        return data;
    }
}
