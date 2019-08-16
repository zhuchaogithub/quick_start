package com.example.web.controller;

import com.example.web.entity.Product;
import com.example.web.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zxc
 * @date 2019/8/16 9:46
 */


@Api(value="/product", tags="测试接口模块")
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value="查询所有信息", notes = "展示所有数据信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> list() {
        List<Product> products = productService.select();
        log.info("查询返回信息：{}", products);
        return products;
    }

    @ApiOperation(value="添加用户信息", notes = "添加用户信息")
//    @ApiImplicitParam(name="product", value="Product", required = true, dataType = "Product")
    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody Product product){
        productService.insert(product);
        return "SUCCESS";
    }

}
