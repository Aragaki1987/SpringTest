package com.san.spring.repository;

import com.san.spring.bean.Spittle;

import java.util.List;

/**
 * Created by AnNN1 on 1/3/2017.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long maxValue, int i);

    Spittle findOne(long spittleId);

    void save(Spittle spitter);
}
