package com.yohansen.testdemo.utils;

import com.yohansen.testdemo.service.InsertDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InsertDataRun implements CommandLineRunner {
    @Autowired
    InsertDataService insertDataService;

    @Override
    public void run(String... args) throws Exception {
        insertDataService.saveDataSample();
    }
}
