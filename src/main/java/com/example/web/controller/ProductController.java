package com.example.web.controller;

import com.example.common.cache.ProductCache;
import com.example.web.entity.Product;
import com.example.web.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.*;

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

    @Autowired
    private ProductCache productCache;

    @ApiOperation(value="查询所有信息", notes = "展示所有数据信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> list() {
//        List<Product> products = productService.select();
        List<Product> products = productCache.select();
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

    @ApiOperation(value="超时处理异常", notes = "超时处理异常")
    @PostMapping("/timeoutDealException")
    @ResponseBody
    public void addAndDealException(){
        final ExecutorService exec = Executors.newFixedThreadPool(1);
        Future<String> future = exec.submit(new Callable<String>() {
            @Override
            public String call() {
                try {
                    //开始执行耗时操作
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("任务被中断。");
                }
                return  "OK";
            }
        });
        try {
//            Future<String> future = exec.submit(call);
            String result = future.get(2, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (InterruptedException |ExecutionException | TimeoutException e) {
            future.cancel(true); //任务停止
            System.out.println("任务超时。");
        }finally {
            System.out.println("清理资源。");
            // 关闭线程池
            exec.shutdown();
        }
    }

}
