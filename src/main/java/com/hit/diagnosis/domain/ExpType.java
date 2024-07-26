package com.hit.diagnosis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 收费类别表
 * @TableName exp_type
 */
@TableName(value ="exp_type")
@Data
public class ExpType implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 收费类别
     */
    private Short diaExpType;

    /**
     * 收费类别名称
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}