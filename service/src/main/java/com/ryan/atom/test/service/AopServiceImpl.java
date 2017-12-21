package com.ryan.atom.test.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/12/1.
 */
@Service("aopService")
public class AopServiceImpl implements AopService {

    @Override
    public void cout() {
        System.out.println("this's func self");
    }

    @Override
    public void aopAround(int num) {
        System.out.println("this's aopAround self " + num);
    }
}
