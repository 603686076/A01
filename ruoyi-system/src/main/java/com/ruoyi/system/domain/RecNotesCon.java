package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 笔记信息对象 rec_notes_con
 * 
 * @author xu
 * @date 2021-04-02
 */
public class RecNotesCon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 笔记id */
    private Long notesId;

    /** 笔记类型 */
    @Excel(name = "笔记类型")
    private Long recordId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 标签 */
    @Excel(name = "标签")
    private String label;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    private int r1_flag;

    private int r2_flag;

    private int r3_flag;

    private int r4_flag;

    public void setNotesId(Long notesId) 
    {
        this.notesId = notesId;
    }

    public Long getNotesId() 
    {
        return notesId;
    }
    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setLabel(String label) 
    {
        this.label = label;
    }

    public String getLabel() 
    {
        return label;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public int getR1_flag() {
        return r1_flag;
    }

    public void setR1_flag(int r1_flag) {
        this.r1_flag = r1_flag;
    }

    public int getR2_flag() {
        return r2_flag;
    }

    public void setR2_flag(int r2_flag) {
        this.r2_flag = r2_flag;
    }

    public int getR3_flag() {
        return r3_flag;
    }

    public void setR3_flag(int r3_flag) {
        this.r3_flag = r3_flag;
    }

    public int getR4_flag() {
        return r4_flag;
    }

    public void setR4_flag(int r4_flag) {
        this.r4_flag = r4_flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("notesId", getNotesId())
            .append("recordId", getRecordId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("label", getLabel())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .toString();
    }
}
