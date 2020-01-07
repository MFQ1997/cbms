package com.gdupt.cbms.entity.vo;


import com.gdupt.cbms.entity.shiro.Role;

import java.util.Arrays;

public class RoleVO extends Role {

    private int [] ids;     //批量获取id，用来进行批量删除操作或者分配权限
    private int page;       //获取显示第几页的内容
    private int rows;       //用来获取一页显示多少条数据

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
        return "RoleVO{" +
                "ids=" + Arrays.toString(ids) +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
