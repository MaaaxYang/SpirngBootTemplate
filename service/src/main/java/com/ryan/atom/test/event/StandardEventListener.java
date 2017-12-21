package com.ryan.atom.test.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/1.
 */
@Component
public class StandardEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent()==null){
            if (contextRefreshedEvent.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
                System.out.println("this's StandardEventListener - start");
                Object source = contextRefreshedEvent.getSource();
                if (source instanceof String){
                    System.out.println("this's source " + String.valueOf(source));
                }
                System.out.println("this's StandardEventListener - end");
            }
        }
    }

//    ContextClosedEvent
//    ContextRefreshedEvent spring容器初始化
//    ContextStartedEvent
//    ContextStoppedEvent
//    RequestHandleEvent
}
