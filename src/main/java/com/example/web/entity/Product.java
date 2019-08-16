package com.example.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author  zxc
 * @date  2019/08/16
 */
@AllArgsConstructor
@Data
public class Product implements Serializable {

    private Long id;
    private String name;
}
