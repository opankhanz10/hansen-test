package com.yohansen.testdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PositionService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper mapper;

    public ResponseEntity<Object> getDataAll(){
        try {

            ResponseEntity<String> result = restTemplate.getForEntity("http://dev3.dansmultipro.co.id/api/recruitment/positions.json", String.class);
            var jsonResp = mapper.readTree(result.getBody());
            return new ResponseEntity<>(jsonResp, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public ResponseEntity<Object> getById(String id){
        try {

            ResponseEntity<String> result = restTemplate.getForEntity("http://dev3.dansmultipro.co.id/api/recruitment/positions/"+id, String.class);
            var jsonResp = mapper.readTree(result.getBody());
            return new ResponseEntity<>(jsonResp, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
