package com.paru.enterprices.admin.controller;

import static com.paru.enterprices.admin.constants.ControllerConstants.DISTRIBUTOR_CONTROLLER;
import static com.paru.enterprices.services.constants.ResponceConstant.*;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paru.enterprices.services.DistributorService;
import com.paru.enterprices.services.dto.UserDto;

@RestController
@RequestMapping(DISTRIBUTOR_CONTROLLER)
@CrossOrigin(origins = "http://psquare51.com")
public class DistributorController {

	@Autowired
	private DistributorService distributorService;

	@PostMapping(value = "/addDistributor")
	public ResponseEntity<String> addDistributor(@RequestBody UserDto userDto) {
		String body = distributorService.addDistributor(userDto);
		if ((emptyMobileNumber).equals(body)) {
			return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
		}
		if ((LOCATION_CAN_NOT_BE_EMPTY).equals(body)) {
			return new ResponseEntity<String>(body, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(body, HttpStatus.OK);

	}

	@GetMapping(value = "distributors")
	public ResponseEntity<List<UserDto>> getDistributors() {
		List<UserDto> distributors = distributorService.getAllDistributors();
		if (distributors != null) {
			return new ResponseEntity<List<UserDto>>(distributors, HttpStatus.OK);
		}
		return new ResponseEntity<List<UserDto>>(distributors, HttpStatus.NOT_FOUND);

	}
	
	@PutMapping("/distributorEnable/{distId}")
	public void distributorEnable(@PathVariable Long distId)
	{
		distributorService.distributorEnable(distId);
		
	}
	
	@GetMapping("/getEnableDistributors")
	public List<UserDto> getEnableDistributors() {
		List<UserDto> distributors = distributorService.getEnableDistributors();
		return distributors;
	}

	@GetMapping("/getDisableDistributors")
	public List<UserDto> getDisableDistributors() {
		List<UserDto> distributors = distributorService.getDisableDistributors();
		return distributors;
	}

	@PutMapping("/distributorDisable/{distId}")
	public void distributorDisable(@PathVariable Long distId) {
		distributorService.distributorDisable(distId);

	}

	}
