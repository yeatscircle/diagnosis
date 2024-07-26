package com.hit.diagnosis.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

/**
 * t_diagnosis_project 诊疗项目信息维护表
 * @TableName t_diagnosis_project
 */
@TableName(value ="t_diagnosis_project")
@Data
public class TDiagnosisProject implements Serializable {
    /**
     * 唯一id
     */
    @TableId
    @ExcelProperty("ID")
    private Long id;

    /**
     * 诊疗项目编码
     */
    @ExcelProperty("诊疗项目编码")
    private String diaId;

    /**
     * 项目名称
     */
    @ColumnWidth(50)
    @ExcelProperty("项目名称")
    private String diaName;

    /**
     * 收费类别
     */
    @ExcelProperty("收费类别")
    private Short diaExpType;

    /**
     * 收费项目等级 0-甲类,1-乙类,2-丙类
     */
    @ExcelProperty("收费项目等级")
    private Short diaExpLevel;

    /**
     * 最高限价
     */
    @ExcelProperty("最高限价")
    private BigDecimal diaMaxPrice;

    /**
     * 开始日期
     */
    @ExcelProperty("开始日期")
    private LocalDate diaStarttime;

    /**
     * 终止日期
     */
    @ExcelProperty("终止日期")
    private LocalDate diaEndtime;

    /**
     * 有效标志 0-无效,1-有效
     */
    @ExcelProperty("有效标志")
    private Short diaValid;

    /**
     * 医院等级 0-一级医院,1-二级医院,2-三级医院,3-社区医院,4-所有医院
     */
    @ExcelProperty("医院等级")
    private Short diaHosLevel;

    /**
     * 是否需要审批标志 0-无需审批,1-需要审批
     */
    @ExcelProperty("是否需要审批标志")
    private Short diaApprovalmark;

    /**
     * 更新日期
     */
    @ExcelProperty("更新日期")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDate updatetime;

    /**
     * 创建日期
     */
    @ExcelProperty("创建日期")
    @TableField(fill = FieldFill.INSERT)
    private LocalDate createtime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TDiagnosisProject other = (TDiagnosisProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getDiaId() == null ? other.getDiaId() == null : this.getDiaId().equals(other.getDiaId()))
                && (this.getDiaName() == null ? other.getDiaName() == null : this.getDiaName().equals(other.getDiaName()))
                && (this.getDiaExpType() == null ? other.getDiaExpType() == null : this.getDiaExpType().equals(other.getDiaExpType()))
                && (this.getDiaExpLevel() == null ? other.getDiaExpLevel() == null : this.getDiaExpLevel().equals(other.getDiaExpLevel()))
                && (this.getDiaMaxPrice() == null ? other.getDiaMaxPrice() == null : this.getDiaMaxPrice().equals(other.getDiaMaxPrice()))
                && (this.getDiaStarttime() == null ? other.getDiaStarttime() == null : this.getDiaStarttime().equals(other.getDiaStarttime()))
                && (this.getDiaEndtime() == null ? other.getDiaEndtime() == null : this.getDiaEndtime().equals(other.getDiaEndtime()))
                && (this.getDiaValid() == null ? other.getDiaValid() == null : this.getDiaValid().equals(other.getDiaValid()))
                && (this.getDiaHosLevel() == null ? other.getDiaHosLevel() == null : this.getDiaHosLevel().equals(other.getDiaHosLevel()))
                && (this.getDiaApprovalmark() == null ? other.getDiaApprovalmark() == null : this.getDiaApprovalmark().equals(other.getDiaApprovalmark()));
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", diaId=").append(diaId);
        sb.append(", diaName=").append(diaName);
        sb.append(", diaExpType=").append(diaExpType);
        sb.append(", diaExpLevel=").append(diaExpLevel);
        sb.append(", diaMaxPrize=").append(diaMaxPrice);
        sb.append(", diaStarttime=").append(diaStarttime);
        sb.append(", diaEndtime=").append(diaEndtime);
        sb.append(", diaValid=").append(diaValid);
        sb.append(", diaHosLevel=").append(diaHosLevel);
        sb.append(", diaApprovalmark=").append(diaApprovalmark);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}