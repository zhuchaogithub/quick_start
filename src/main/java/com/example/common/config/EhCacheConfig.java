package com.example.common.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zxc
 * @date 2019/8/16 15:39
 */

@Configuration
public class EhCacheConfig {
    @Value(value = "${spring.cache.ehcache.config}")
    private String ehcacheConfigResource;

    /**
     * 据shared与否的设置,Spring分别通过CacheManager.create()或new CacheManager()方式来创建一个ehcache基地.
     */
    @Bean(name="ehCacheManagerFactoryBean")
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation (new ClassPathResource(ehcacheConfigResource.replaceFirst("classpath:", "").replaceFirst("classpath*:", "")));
        cacheManagerFactoryBean.setShared (true);
        cacheManagerFactoryBean.setCacheManagerName("cacheManagerName");

        return cacheManagerFactoryBean;
    }

    /**
     * ehcache 主要的管理器
     */
//    @Primary
    @Qualifier("ehCacheCacheManager")
    @Bean(name = "ehCacheCacheManager")
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
        EhCacheCacheManager ehCacheCacheManager= new EhCacheCacheManager(bean.getObject());
        return ehCacheCacheManager;
    }
}
