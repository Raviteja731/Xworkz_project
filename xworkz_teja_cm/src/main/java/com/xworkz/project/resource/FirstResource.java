package com.xworkz.project.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.project.dto.XworkzDto;
import com.xworkz.project.service.XworkzService;

import lombok.Value;

@RestController
@EnableWebMvc
@RequestMapping("/")
public class FirstResource {

	@Autowired
	private XworkzService xworkzService;
	
	public FirstResource() {
		System.out.println("Cteated FirstResource...."+getClass().getSimpleName());
	}
	
	@GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onEmail(@PathVariable String email) {
		List<XworkzDto> List = this.xworkzService.findAll();
		System.err.println(email);
		for (XworkzDto dto : List) {
			if (email.equals(dto.getEmail())) {
				System.err.println("Running equals condition");
				return "Email id exsist";
			}
		}
		return "";
	}
	
	@GetMapping(value ="/mobileNo/{mobileNo}",produces  = MediaType.APPLICATION_JSON_VALUE)
	public String onMobileNo(@PathVariable long mobileNo) {
		List<XworkzDto> list = xworkzService.findAll();
		System.err.println(mobileNo);
		for(XworkzDto dto : list) {
			if(mobileNo == dto.getMobileNo())
			{
				System.err.println("Running MobileNo Validation Method");
				return "MobileNo already exist";
			}
		}
		return "";
	}
	
	@GetMapping(value = "/userId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String userId(@PathVariable String userId) {
		List<XworkzDto> list = xworkzService.findAll();
		System.err.println(userId);
		for(XworkzDto dto : list) {
			if(userId.equals(dto.getUserId())) {
				System.err.println("Running UserId Validation Method");
				return "UserId already exist";
			}
		}
		return "";
	}
}
t