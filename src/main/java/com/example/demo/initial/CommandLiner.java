/*
 * Copyright (c) 2013-2017, suimi
 */
package com.example.demo.initial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author suimi
 * @date 2018/6/11
 */
@Component @Slf4j public class CommandLiner implements CommandLineRunner {
    @Override public void run(String... args) throws Exception {
        log.info("CommandLiner run");
    }
}
