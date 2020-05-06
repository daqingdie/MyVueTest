package com.lq.demo.controller;


import com.lq.demo.domain.User;
import com.lq.demo.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "+", maxAge = 3600)

public class VueController {
    @Autowired
    private DemoMapper demoMapper;

    @PostMapping("vueAll")
    public User selectAll(@RequestBody Map map) {
        User user = new User();
        System.out.println(map);
        return user;
    }
}
