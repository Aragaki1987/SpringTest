package com.san.spring.repository;

import com.san.spring.bean.Spitter;

/**
 * Created by AnNN1 on 1/3/2017.
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
