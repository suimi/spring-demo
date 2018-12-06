/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.initial;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author suimi
 * @date 2018/6/11
 */
@ToString()
@Service @Slf4j public class BInit extends AbstractInit {

    @Autowired AInit aInit;

    public void setAInit(AInit aInit) {
        this.aInit = aInit;
        log.info("BInit.set");
    }
}
