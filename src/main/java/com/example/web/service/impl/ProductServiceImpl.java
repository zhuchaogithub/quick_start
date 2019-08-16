package com.example.web.service.impl;

import com.example.common.annotation.DataSource;
import com.example.web.dao.ProductDao;
import com.example.web.entity.Product;
import com.example.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  zxc
 * @date  2019/08/16
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @DataSource(name = "MASTER")
    public List<Product> select() {
        return productDao.select();
    }

    @Override
    @DataSource(name = "SLAVE")
    public void insert(Product product){
        productDao.insert(product);
    }
}
