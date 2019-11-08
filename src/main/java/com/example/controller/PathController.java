package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathController {

    @RequestMapping("/getpath")
    public String getRsourcePath() {
        return Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }
}
