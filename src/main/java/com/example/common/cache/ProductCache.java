package com.example.common.cache;

import com.example.web.entity.Product;
import com.example.web.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author zxc
 * @date 2019/8/16 15:48
 */

@Slf4j
@Component
public class ProductCache {

    @Autowired
    private ProductService productService;

    @Cacheable(value = "productCache")
    public List<Product> select() {
        return productService.select();
    }
}
