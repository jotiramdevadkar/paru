package com.paru.enterprices.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.paru.enterprices.common.dto.NameDto;
import com.paru.enterprices.services.CustomerService;
import com.paru.enterprices.services.DistributorService;
import com.paru.enterprices.services.TelecallerService;
import com.paru.enterprices.services.dto.BulkAllotementDto;
import com.paru.enterprices.services.dto.CustomerDto;
import com.paru.enterprices.services.dto.CustomerGridDto;
import static com.paru.enterprices.admin.constants.ControllerConstants.*;

@RestController
@RequestMapping(CUSTOMER_CONTROLER)
@CrossOrigin(origins ="http://localhost:4200")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DistributorService distributorService;
	
	@Autowired
	private TelecallerService telecallerService; 
	
	@RequestMapping(method=RequestMethod.POST)
	public void save(@RequestBody CustomerDto customerDto){
		customerService.save(customerDto);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="allotment" ,method=RequestMethod.PUT)
	public void allotment(@RequestBody BulkAllotementDto allotementDto){
		customerService.allotment(allotementDto);
	}
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public Page<CustomerGridDto> search(@RequestParam("mobileNo") String mobileNo, @RequestParam(name="tcId", required=false) Long tcId,
			@RequestParam(name="distributorId", required=false) Long distributorId, Pageable pageable ){
		System.out.println("@@ Page number = " + pageable.getPageNumber());
		System.out.println("@@ Page Size = " + pageable.getPageSize());
		return customerService.search(mobileNo, tcId,distributorId, pageable);
	}
	
	@RequestMapping(value = "distributors", method=RequestMethod.GET)
	public List<NameDto> getDistributors(){
		return distributorService.getDistributors();
	}
	
	@RequestMapping(value = "mobileno/isexist/{mobileNo}", method=RequestMethod.GET)
	public boolean isMobileNoExists(@PathVariable("mobileNo") String mobileNo){
		return customerService.isMobileNoExists(mobileNo);
	}
	
	@RequestMapping(value = "telecallers", method=RequestMethod.GET)
	public List<NameDto> getTelecaller(){
		return telecallerService.getTelecallers();
	}
	
	@RequestMapping(value = "orgtypes", method=RequestMethod.GET)
	public List<NameDto> getOrganizationType(){
		return customerService.getOrganizationType();
	}
}
