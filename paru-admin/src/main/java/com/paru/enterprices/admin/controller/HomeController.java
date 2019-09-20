package com.paru.enterprices.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paru.enterprices.services.ProductService;
import com.paru.enterprices.services.dto.ProductDto;

@RestController
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("test")
	public ProductDto test(){
		return productService.test();
	}
}
