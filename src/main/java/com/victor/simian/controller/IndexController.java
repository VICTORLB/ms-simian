package com.victor.simian.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {

	
	@RequestMapping("/")
	String home () {
		return "Test Simios!";
	}
	
}
