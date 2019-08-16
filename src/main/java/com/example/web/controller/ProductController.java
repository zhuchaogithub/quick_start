package com.example.web.controller;

import com.example.web.entity.Product;
import com.example.web.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zxc
 * @date 2019/8/16 9:46
 */

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Product> list() {
        List<Product> products = productService.select();
        log.info("查询返回信息：{}", products);
        return products;
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody Product product){
        productService.insert(product);
        return "SUCCESS";
    }

}
