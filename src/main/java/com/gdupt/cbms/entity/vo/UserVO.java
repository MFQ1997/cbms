package com.gdupt.cbms.entity.vo;


import com.gdupt.cbms.entity.shiro.User;

import java.util.Arrays;

public class UserVO extends User {

    private int[] ids;          //获取批量的用户id，用以批量删除功能或者是添加角色
    private int page;           //显示第几页的信息
    private int rows;           //一页显示多少条数据

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
        return "UserVO{" +
                "ids=" + Arrays.toString(ids) +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
