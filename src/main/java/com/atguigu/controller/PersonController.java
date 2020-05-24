package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atguigu.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;

}
