package com.ryan.atom.test.autoConfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(MyConfigurationCondition.class)
@EnableConfigurationProperties(MyConfigurationProperties.class)
public class MyAutoConfig {

    private final MyConfigurationProperties myConfigurationProperties;

    public MyAutoConfig(MyConfigurationProperties myConfigurationProperties) {
        this.myConfigurationProperties = myConfigurationProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public MyBean getMyBean() {
        MyBean bean =new MyBean();
        bean.setWhat(myConfigurationProperties.getPropertyB());
        return bean;
    }

}
