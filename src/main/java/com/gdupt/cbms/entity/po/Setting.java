package com.gdupt.cbms.entity.po;

public class Setting {

    private Integer id;         //主键Id
    private String siteName;    //系统的名称
    private String siteUrl;     //系统的域名
    private String copyright;   //系统的备案号
    private String remark;      //备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "id=" + id +
                ", siteName='" + siteName + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", copyright='" + copyright + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
