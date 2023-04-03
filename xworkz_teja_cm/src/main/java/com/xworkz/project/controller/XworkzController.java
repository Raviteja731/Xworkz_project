package com.xworkz.project.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.project.dto.XworkzDto;
import com.xworkz.project.service.XworkzService;

@Controller
@RequestMapping("/")
public class XworkzController {

	@Autowired
	private XworkzService xworkzService;

	public XworkzController() {
		System.out.println("Created XworkzController in controller...." + getClass().getSimpleName());
	}

	@PostMapping("signUp")
	public String info(XworkzDto dto, Model model) {
		List<XworkzDto> dtos = xworkzService.findAll();
		for (XworkzDto dto1 : dtos) {
			System.out.println(dto1);
			if (dto.getUserId().equals(dto1.getUserId())) {
				model.addAttribute("UserIdExist", "UserId already exist");
				return "index";
			} else if (dto.getEmail().equals(dto1.getEmail())) {
				model.addAttribute("EmailExisted", "Email already exist");
				return "index";
			} else if (dto.getMobileNo() == (dto1.getMobileNo())) {
				model.addAttribute("MobileNoExist", "Mobile no already exist");
				return "index";
			}
		}

		if (dto.getPassword().equals(dto.getConfirmPassword())) {
			Set<ConstraintViolation<XworkzDto>> violations = xworkzService.validateAndsave(dto);
			if (violations.isEmpty()) {
				model.addAttribute("message", "data saved sucessfull");
				System.out.println("" + dto);
				return "index";

			} else {
				model.addAttribute("errors", violations);
				model.addAttribute("message", "data not saved");
			}
			return "index";
		} else {
			model.addAttribute("password", "Password and conformPassword must be same");
		}

		return "index";
	}
}
