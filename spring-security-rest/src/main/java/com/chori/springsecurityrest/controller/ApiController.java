package com.chori.springsecurityrest.controller;

import com.chori.springsecurityrest.dto.Foo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping(value = "/foos")
    public List<Foo> foos() {
        List<Foo> foos = new ArrayList<>();
        foos.add(new Foo().setId(0).setName("JbidXc"));

        return foos;
    }

    @GetMapping("/text")
    public String text() {
        return "test";
    }
}
