package com.yjsong.springsecurityrest.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjsong.springsecurityrest.VO.Foo;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@GetMapping("/foos")
	public ArrayList<Foo> foos() {
		ArrayList<Foo> fooList = new ArrayList<Foo>();
		Foo foo = new Foo();
		foo.setId(0);
		foo.setName("JbidXc");
		fooList.add(foo);
		return fooList;
    }
	
}