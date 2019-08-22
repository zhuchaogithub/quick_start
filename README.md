#quick_start
##简介：
基于springboot2.0的快速搭建项目框架，集成mybatis同时集成Druid实现动态切换数据库，集成swagger2实现在线api生成；
通过logback生成记录日志文件；整合Ehcache缓存实现二级缓存，并在此基础上整合了redis，我们能够灵活使用缓存方式。

##使用方式：
  ###Druid动态使用：
  1. 在配置文件中设置不同的数据源，同时开启从数据源
  2. 在方法上添加@DataSource(name = "MASTER")，MASTER为主库，SLAVE为从库
  
  ###swagger的使用：
  1. 直接启动项目访问http://localhost:19081/swagger-ui.html
  2. 在相应的类与方法上添加swagger注解
  
  ###ehcache使用：
  参考cache包下，同时别忘了配置配置文件
  
  ###redis使用：
  参考测试类Test
  
  
  
  
  
  
  
  > @kidding·人生 
  
