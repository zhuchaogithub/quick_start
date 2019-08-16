package com.example.web.service;

import com.example.web.entity.Product;

import java.util.List;

/**
 * @author  zxc
 * @date  2019/08/16
 */
public interface ProductService {
    public List<Product> select();

    void insert(Product product);
}
