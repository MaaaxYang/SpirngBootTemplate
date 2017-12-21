package com.ryan.atom.dao;

import com.ryan.atom.model.BPayBatch;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/12/1.
 */
@Mapper
public interface BPayBatchDao {
    BPayBatch firstOrDefault();
}
