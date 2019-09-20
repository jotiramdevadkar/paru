package com.paru.enterprices.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.paru.enterprices.services.dto.OrderReport;

public interface AdminOrderService {

	Page<OrderReport> orderReport(String orderStatus, Pageable pageable);

}
