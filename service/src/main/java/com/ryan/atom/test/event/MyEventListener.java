package com.ryan.atom.test.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/1.
 */
@Component
public class MyEventListener implements ApplicationListener {

    /**
     * 这种写法会导致事件执行2次，因为父子容器的原因
     * @param applicationEvent
     */
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("this's myEventListener - start");
        Object source = applicationEvent.getSource();
        if (source instanceof String){
            System.out.println("this's source " + String.valueOf(source));
        }
        System.out.println("this's myEventListener - end");
    }
}
