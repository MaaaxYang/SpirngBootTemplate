package com.ryan.atom.test.beans;

import com.ryan.atom.test.MessageService;
import com.ryan.atom.test.aop.AopTest;
import com.ryan.atom.test.aop.HighAspectJ;
import com.ryan.atom.test.beans.conditionnal.BeanConditionnal;
import com.ryan.atom.test.utils.BeanUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Administrator on 2017/12/1.
 */
@Configuration
public class ConfigBean {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World! this's bean";
            }
        };
    }

    @Bean(name = "profileBean")
    @Profile("dev")
    String profileBean()
    {
        return "this's profileBean dev";
    }


    @Bean(name = "conditionalBean")
    @Conditional(BeanConditionnal.class)
    String conditionalBean()
    {
        return "this's conditionalBean";
    }

    @Bean
    public HighAspectJ highAspectJ()
    {
        return new HighAspectJ();
    }

    @Bean
    public AopTest aopTest(){
        AopTest test = BeanUtil.newInstance(AopTest.class);
        return test;
    }
}
