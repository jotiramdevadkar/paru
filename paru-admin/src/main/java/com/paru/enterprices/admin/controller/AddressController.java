package com.paru.enterprices.admin.controller;

import static com.paru.enterprices.admin.constants.ControllerConstants.ADDRESS_CONTROLER;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paru.enterprices.common.dto.NameDto;
import com.paru.enterprices.services.AddressService;
import com.paru.enterprices.services.dto.PincodePost;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(ADDRESS_CONTROLER)
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@RequestMapping("state")
	public Set<NameDto> getStates(){
		return addressService.getStates();
	}
	
	@RequestMapping("state/{stateId}/district")
	public Set<NameDto> getDistricts(@PathVariable("stateId") Long stateId){
		return addressService.getDistricts(stateId);
	}
	
	@RequestMapping("district/{districtId}/tehsil")
	public Set<NameDto> getTeshil(@PathVariable("districtId") Long districtId){
		return addressService.getTeshil(districtId);
	}

	@RequestMapping("tehsil/{tehsilId}/post")
	public Set<NameDto> getPosts(@PathVariable("tehsilId") Long tehsilId){
		return addressService.getPosts(tehsilId);
	}

	@RequestMapping("post/{postId}/area")
	public Set<NameDto> getAreas(@PathVariable("postId") Long postId){
		return addressService.getAreas(postId);
	}
	
	@RequestMapping("area/{areaIds}/landmark")
	public Set<NameDto> getLandmarks(@PathVariable("areaIds")Long[] areaIds){
		return addressService.getLandmarks(areaIds);
	}

	@RequestMapping("pincode")
	public Set<NameDto> getPincodes(){
		return addressService.getPincodes();
	}
	
	@RequestMapping("pincode/{pincodeId}/all")
	public PincodePost getPincodePost(@PathVariable("postId")String pincodeId){
		return addressService.getPincodePost(pincodeId);
	}
	
	@RequestMapping("post/{postId}/pincode")
	public Set<NameDto> getPincodeByPost(@PathVariable("postId")Long postId){
		return addressService.getPincodeByPost(postId);
	}
	
	@RequestMapping("area/{areaIds}/society")
	public Set<NameDto> getSocieties(@PathVariable("areaIds")Long[] areaIds){
		return addressService.getSocieties(areaIds);
	}

	@RequestMapping("society/{societyId}/wing")
	public Set<NameDto> getWings(@PathVariable("societyId")Long societyId){
		return addressService.getWings(societyId);
	}

}
