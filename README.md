# quick_start
简介：
基于springboot2.0的快速搭建项目框架，集成mybatis同时集成Druid实现动态切换数据库，通过logback生成记录日志文件，
后续将添加Ehcache缓存，redis等项目通用模块。

使用方式：
  Druid动态使用：
  1：在配置文件中设置不同的数据源，同时开启从数据源
  2：在方法上添加@DataSource(name = "MASTER")，MASTER为主库，SLAVE为从库
  
