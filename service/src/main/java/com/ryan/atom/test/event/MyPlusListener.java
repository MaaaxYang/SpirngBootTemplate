package com.ryan.atom.test.event;

import org.springframework.context.ApplicationListener;

/**
 * Created by Administrator on 2017/12/1.
 */
public class MyPlusListener implements ApplicationListener<MyPlusEvent> {
    @Override
    public void onApplicationEvent(MyPlusEvent myPlusEvent) {
        if (myPlusEvent.getApplicationContext().getParent()==null){
            if (myPlusEvent.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
                System.out.println("this's myPlusEvent - start");
                Object source = myPlusEvent.getSource();
                if (source instanceof String){
                    System.out.println("this's source " + String.valueOf(source));
                }
                System.out.println("this's myPlusEvent - end");
            }
        }
    }
}
