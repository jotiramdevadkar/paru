package com.paru.enterprices.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paru.enterprices.admin.service.AdminOrderService;
import com.paru.enterprices.database.dao.OrderDAO;
import com.paru.enterprices.database.entity.Order;
import com.paru.enterprices.services.dto.OrderReport;

@Service
public class AdminOrderServiceImpl implements AdminOrderService{
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public Page<OrderReport> orderReport(String orderStatus, Pageable pageable) {

		List<Order> orders = null;
		Long total = null; 
		
		if(orderStatus.equals("All")){
			orders = orderDAO.byAll(pageable);
			total = orderDAO.countByAll(pageable);
		}else{
			
			orders = orderDAO.byStatus(orderStatus);
			total = orderDAO.countByStatus(orderStatus, pageable);
		}
		List<OrderReport> orderReports = new ArrayList<>();
		for (Order order : orders) {
			OrderReport orderReport = new OrderReport();
			orderReport.convertToDto(order);
			orderReports.add(orderReport );
		}
		
		Page<OrderReport> page = new PageImpl<>(orderReports, pageable, total);
		return page;
	
	}

}
