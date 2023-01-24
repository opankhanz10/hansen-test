package com.yohansen.testdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yohansen.testdemo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("test")
    public ResponseEntity<String> test(
    ) {
        return new ResponseEntity<>("Berhasil", HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<Object> all(
    ) {
        return positionService.getDataAll();
    }

    @GetMapping("by-id/{id}")
    public ResponseEntity<Object> byId(
            @PathVariable("id") String id
    ) {
        return positionService.getById(id);
    }
}
