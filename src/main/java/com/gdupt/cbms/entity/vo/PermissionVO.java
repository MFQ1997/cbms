package com.gdupt.cbms.entity.vo;

import com.gdupt.cbms.entity.shiro.Permission;

import java.util.Arrays;

public class PermissionVO extends Permission {

    private int [] ids;     //获取批量删除的id
    private int page;       //显示哪一页的信息
    private int rows;       //一页显示多少条数据

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PermissionVO{" +
                "ids=" + Arrays.toString(ids) +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
