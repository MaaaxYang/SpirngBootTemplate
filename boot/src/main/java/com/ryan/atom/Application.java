package com.ryan.atom;

import com.ryan.atom.test.service.AopService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2017/11/30.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.ryan.atom"})
@MapperScan({"com.ryan.atom.dao"})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {

    public static  void main(String[] args) throws Exception
    {
         ConfigurableApplicationContext context = SpringApplication.run(Application.class);
         System.out.println("end");
//         AopService service = context.getBean(com.ryan.atom.test.service.AopServiceImpl.class);
//         System.out.println("end");
    }
}
