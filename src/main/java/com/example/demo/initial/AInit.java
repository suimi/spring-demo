/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.initial;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author suimi
 * @date 2018/6/11
 */
@ToString()
@Service @Slf4j public class AInit extends AbstractInit{

    @Autowired private CInit cInit;

    private String hello = "hello word";

    public void setHello(String hello) {
        this.hello = hello;
        log.info("AInit.set hello");
    }

    public void setCInit(CInit cInit) {
        this.cInit = cInit;
        log.info("CInit.set");
    }
}
