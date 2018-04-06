package com.chori.springsecurityrest.controller;

import com.chori.springsecurityrest.dto.Foo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/foos")
    public List<Foo> foos() {
        System.out.println("access /api/foos");
        return Arrays.asList(
                new Foo().setId(0).setName("JbidXc")
        );
    }
}
