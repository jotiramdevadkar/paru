package com.paru.enterprices.admin.controller;

import static com.paru.enterprices.admin.constants.ControllerConstants.ORDER_CONTROLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paru.enterprices.admin.service.AdminOrderService;
import com.paru.enterprices.common.dto.NameDto;
import com.paru.enterprices.services.OrderService;
import com.paru.enterprices.services.dto.OrderReport;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ORDER_CONTROLER)
public class OrderController {

	@Autowired
	private AdminOrderService adminOrderService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("report/{status}")
	public Page<OrderReport> orderReport(@PathVariable("status") String orderStatus, Pageable pageable){
		return adminOrderService.orderReport(orderStatus, pageable);
	}
	
	@RequestMapping(value ="status", method=RequestMethod.GET)
	public List<NameDto> getAllOrderStatus(){
		return orderService.getAllOrderStatus();
	}
}
