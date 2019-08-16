package com.example.web.dao;

import com.example.web.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author  zxc
 * @date  2019/08/16
 */
@Component
public interface ProductDao {

    List<Product> select();

    void insert(Product product);
}
