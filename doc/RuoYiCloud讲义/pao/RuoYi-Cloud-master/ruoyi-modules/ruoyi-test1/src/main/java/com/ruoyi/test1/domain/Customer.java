package com.ruoyi.test1.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 顾客中心对象 customer
 * 
 * @author 王清江
 * @date 2024-04-22
 */
public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 照片墙 */
    @Excel(name = "照片墙")
    private String pictures;

    /** 文件 */
    @Excel(name = "文件")
    private String files;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPictures(String pictures) 
    {
        this.pictures = pictures;
    }

    public String getPictures() 
    {
        return pictures;
    }
    public void setFiles(String files) 
    {
        this.files = files;
    }

    public String getFiles() 
    {
        return files;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("avatar", getAvatar())
            .append("name", getName())
            .append("pictures", getPictures())
            .append("files", getFiles())
            .toString();
    }
}
