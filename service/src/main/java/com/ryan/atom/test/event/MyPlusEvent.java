package com.ryan.atom.test.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * Created by Administrator on 2017/12/1.
 */
public class MyPlusEvent extends ApplicationContextEvent{

    public MyPlusEvent(ApplicationContext source) {
        super(source);
    }

}
