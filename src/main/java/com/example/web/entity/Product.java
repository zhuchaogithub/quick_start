package com.example.web.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author  zxc
 * @date  2019/08/16
 */
@ApiModel(value = "测试实体", description = "Product Entity")
@AllArgsConstructor
@Data
public class Product implements Serializable {

    @ApiModelProperty(value = "主键id", required = true)
    private Long id;
    @ApiModelProperty(value = "名称", required = true)
    private String name;
}
