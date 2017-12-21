package com.ryan.atom.test.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Administrator on 2017/12/1.
 */
public class MyEvent extends ApplicationEvent {
    public MyEvent(String source) {
        super(source);
    }
}
