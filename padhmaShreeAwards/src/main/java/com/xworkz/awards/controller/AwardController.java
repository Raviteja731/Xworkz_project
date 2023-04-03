
 package com.xworkz.awards.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.awards.dto.AwardDTO;
import com.xworkz.awards.service.AwardService;

@Controller
@RequestMapping("/")
public class AwardController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AwardService awardService;

	public AwardController() {
		log.info("created AwardController...");
		
	}

	@GetMapping("/abc")
	public String awards() {
		log.info("rUNNING GET mapping");
		return "index";
	}

	@PostMapping("/abc")
	public String awards(AwardDTO dto, Model model) {

		log.info("Created awards....");
		Set<ConstraintViolation<AwardDTO>> violations = awardService.validateAndSave(dto);
		if (!violations.isEmpty()) {
			log.info("viloation is there ");
			model.addAttribute("dto", dto);
		} else {
			log.info("viloation is not there");
			model.addAttribute("error", violations);
		}
		model.addAttribute("AwardName", dto.getAwardName());
		model.addAttribute("firstReciverName", dto.getFirstReciverName());
		model.addAttribute("recivedDate", dto.getRecivedDate());
		model.addAttribute("GivenBy", dto.getGivenBy());
		model.addAttribute("Recived", dto.isRecived());
		model.addAttribute("Not_Recived", dto.isNot_Recived());
		log.info("Dto",dto);

		return "SucessPage";
	}

	@GetMapping("se")
	public String search(@RequestParam int id,Model model) {
	AwardDTO awardDTO =	awardService.findby(id);
		if (awardDTO!=null) {
			log.info("==========================================");
			log.info("AwardDto",awardDTO);
			model.addAttribute("AwardDTO", awardDTO);
			return "searchPage";
		}
		else {
			System.err.println("id not found");
			return "searchPage";
		}
		
	}
	
	@GetMapping("/findByAwardName")
	public String findName(Model model,@RequestParam String AwardName) {
		
		log.info("Running findName...");
		List<AwardDTO> list = awardService.findAwardName(AwardName);
		
		if(list!= null&& !list.isEmpty()) {
			model.addAttribute("list", list);
			return "findByAwardName";
		}else {
			System.err.println("Dataa is not Found");
			return "findByAwardName";
		}
		
	}
	
	@GetMapping("/update")
	public String onUpdate(@RequestParam int id,Model model) {
		log.info("Running onUpdate"+id);
		AwardDTO dto= this.awardService.findby(id);
		model.addAttribute("dto",dto);
		
		return "Update";
	}
	
	@PostMapping("/update")
	public String onUpdate(Model model,AwardDTO awardDto) {
		log.info("Running onUpdate post");
		Set<ConstraintViolation<AwardDTO>> violtion= this.awardService.validateAndUpdate(awardDto);
		if(!violtion.isEmpty()) {
			model.addAttribute("err",violtion);
			return "Update";
		}else {
			model.addAttribute("msg", "Updated Successfully");
		return "Update";
		}
	}
	
	@GetMapping("/delete")
	public String onDelete(@RequestParam int id,Model model) {
		log.info("Running onDelete");
		boolean delete=this.awardService.validateAndDelete(id);
		if(delete=true) {
			log.info("deleted data of :"+id);
			model.addAttribute("delete", "Deleted successfully : ID : ");
			model.addAttribute("id",id);
		}else {
			model.addAttribute("notDeleted","Id not found");
		}
		return "findByAwardName";
	}
}
