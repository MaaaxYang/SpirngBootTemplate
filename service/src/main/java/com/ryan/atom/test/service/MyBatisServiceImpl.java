package com.ryan.atom.test.service;

import com.ryan.atom.model.BPayBatch;
import com.ryan.atom.dao.BPayBatchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/12/1.
 */
@Service("myBatisService")
public class MyBatisServiceImpl implements MyBatisService {

    @Autowired
    private BPayBatchDao bPayBatchDao;

    @Override
    @Transactional
    public BPayBatch get() {

        return bPayBatchDao.firstOrDefault()
                ;
    }
}
