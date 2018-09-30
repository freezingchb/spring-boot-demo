package com.example.demo.page;

import java.io.Serializable;

public class PageInfo implements Serializable {
    private Integer total      = 0;    // 总记录数
    private Integer pageSize   = 20;   // 默认每页显示记录数
    private Integer lastPage   = 1;    // 总页数
    private Integer page       = 1;    // 当前页
    private int[] pageNumbers;        // 当前页

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public int[] getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int[] pageNumbers) {
        this.pageNumbers = pageNumbers;
    }
}
