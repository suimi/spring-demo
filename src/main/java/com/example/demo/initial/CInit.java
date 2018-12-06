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
@ToString(exclude = "bInit")
@Service @Slf4j public class CInit extends AbstractInit {

    @Autowired BInit bInit;

    public void setBInit(BInit bInit) {
        this.bInit = bInit;
        log.info("CInit.set");
    }
}
