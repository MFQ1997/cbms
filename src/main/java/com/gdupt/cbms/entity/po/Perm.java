package com.gdupt.cbms.entity.po;

import lombok.Value;

import java.beans.Transient;
import java.util.List;

public class Perm {

    private Integer id;
    private Integer pid;
    private String name;
    private String open;
    private String checked;

    private List<Perm> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public List<Perm> getChildren() {
        return children;
    }

    public void setChildren(List<Perm> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Perm{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", open='" + open + '\'' +
                ", checked='" + checked + '\'' +
                ", children=" + children +
                '}';
    }
}
