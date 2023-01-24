package com.yohansen.testdemo.service;

import com.yohansen.testdemo.entity.UserEntity;
import com.yohansen.testdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InsertDataService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveDataSample(){
        var userAdmin = new UserEntity(Long.valueOf(1),"admin",passwordEncoder.encode("admin"));
        if(userRepository.findFirstByUsername(userAdmin.getUsername()) == null){
            userRepository.save(userAdmin);
            log.info("Generate User Success");
        }
        var user = new UserEntity(Long.valueOf(2),"user",passwordEncoder.encode("user"));
        if(userRepository.findFirstByUsername(user.getUsername())==null){
            userRepository.save(user);
            log.info("Generate User Success");
        }

    }
}
