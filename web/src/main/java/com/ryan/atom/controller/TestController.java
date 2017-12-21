package com.ryan.atom.controller;

import com.ryan.atom.model.BPayBatch;
import com.ryan.atom.test.*;
import com.ryan.atom.test.annotation.MyAnnotationTest;
import com.ryan.atom.test.aop.AopTest;
import com.ryan.atom.test.aop.MyDynamicProxy;
import com.ryan.atom.test.async.MyAsyncDemo;
import com.ryan.atom.test.event.MyEventPublisher;
import com.ryan.atom.test.proxy.MyProxyHandler;
import com.ryan.atom.test.proxy.MyProxyTest;
import com.ryan.atom.test.proxy.MyProxyTestInterface;
import com.ryan.atom.test.service.*;
import com.ryan.atom.test.utils.BeanUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/11/30.
 */
@RestController
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);


    @Autowired
    public MessageService messageService;

    //@Autowired
    //public AopService aopService;

    @Autowired
    public MyBatisService myBatisService;

    @Autowired
    public MyEventPublisher myEventPublisher;

    @Autowired
    private AopTest aopTest;

    @RequestMapping("/")
    public String home() {
        logger.info("home ~ ");
        return "Hello World!";
    }

    @RequestMapping("/bean")
    public String bean() {
        return messageService.getMessage();
    }

    @RequestMapping("/beanUtil")
    public String beanUtil() {
        MessageService messageService2 = BeanUtil.getBean(MessageService.class);
        return messageService2.getMessage();
    }

    @RequestMapping("/profileBean")
    public String profileBean() {
        String res = BeanUtil.getBean("profileBean",String.class);
        return res;
    }

    @RequestMapping("/conditionalBean")
    public String conditionalBean() {
        String res = BeanUtil.getBean("conditionalBean",String.class);
        return res;
    }

//    @RequestMapping("/aop")
//    public String aop() {
//        aopService.cout();
//        return "ok";
//    }
//
//    @RequestMapping("/aopAround")
//    public String aopAround() {
//        aopService.aopAround(1);
//        return "ok aopAround";
//    }

    @RequestMapping("/bPayBatch")
    public String bPayBatch() {
        BPayBatch bPayBatch = myBatisService.get();
        return "ok bPayBatch";
    }

    @RequestMapping("/myEvent")
    public String myEvent() {
        myEventPublisher.setMsg("ha lou a");
        myEventPublisher.sendMsg();
        return "ok myEvent";
    }

    @RequestMapping("/myEvent2")
    public String myEvent2() {
        myEventPublisher.setMsg("ha lou a");
        myEventPublisher.sendMsg2();
        return "ok myEvent2";
    }

    @RequestMapping("/myAsync")
    public String myAsync() {
        System.out.println("myAsync -start");
        Thread thread = new Thread(new MyAsyncDemo(),"T-MyAsyncDemo");
        thread.start();
        System.out.println("myAsync -end");
        return "ok myAsync";
    }

    @RequestMapping("/aopTest")
    public String aopTest() {
        aopTest.hello();
        aopTest.select();
        aopTest.insert();
        return "ok aopTest";
    }

    @RequestMapping("/myException")
    public String myException() {
        MyTransactionService.funcA();
        return "ok myException";
    }

    @RequestMapping("/myProxy")
    public String myProxy() {

        MyProxyTestInterface test = (MyProxyTestInterface)Proxy.newProxyInstance(MyProxyTest.class.getClassLoader(),new Class[]{MyProxyTestInterface.class},new MyProxyHandler(new MyProxyTest("go go go")));
        test.test();
        return "ok myException";
    }

    @RequestMapping("/myAnnotation")
    public String myAnnotation() {
        MyAnnotationTest test = new MyAnnotationTest();
        test.analyze();
        return "ok myAnnotation";
    }
}
