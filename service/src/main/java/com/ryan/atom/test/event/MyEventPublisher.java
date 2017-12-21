package com.ryan.atom.test.event;

import com.ryan.atom.test.utils.BeanUtil;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/1.
 */
@Component
public class MyEventPublisher implements ApplicationEventPublisherAware {

    private String msg;

    public String getMsg() {
        if (msg==null){
            return "";
        }
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private ApplicationEventPublisher myEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        myEventPublisher = applicationEventPublisher;
    }

    public void sendMsg()
    {
        System.out.println("this's my event " + msg);
        myEventPublisher.publishEvent(new MyEvent(" what? "));
    }

    public void sendMsg2()
    {
        System.out.println("this's my event " + msg);
        myEventPublisher.publishEvent(new MyPlusEvent(BeanUtil.getBeanFactory()));
    }
}
