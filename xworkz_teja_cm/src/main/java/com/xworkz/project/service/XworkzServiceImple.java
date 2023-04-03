package com.xworkz.project.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.project.dto.XworkzDto;
import com.xworkz.project.entity.XworkzEntity;
import com.xworkz.project.repository.XworkzRepository;

@Service
public class XworkzServiceImple implements XworkzService {


	@Autowired
	private XworkzRepository repository;

	public XworkzServiceImple() {
		System.out.println("Created XworkzServiceImple..." + getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<XworkzDto>> validateAndsave(XworkzDto dto) {
		System.out.println("Running validateAndsave in ServiceImple....");
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<XworkzDto>> violations = validator.validate(dto);
		if(violations!=null&&!violations.isEmpty()) {
			System.out.println("violations in Dto is There..."+dto);
			return violations;
		}else {
			System.out.println("violations is not there in Dto.."+dto);
			XworkzEntity entity = new XworkzEntity();
			entity.setCreatedBy(dto.getUserId());
			entity.setCreatedDateTime(LocalDateTime.now());
			System.out.println("dto"+dto);
			BeanUtils.copyProperties(dto, entity);
			System.out.println("Entity"+entity);
		boolean savve = repository.save(entity);
		System.out.println("Info is Saved"+savve);
		
		return Collections.emptySet();
		}
		
	}

	@Override
	public List<XworkzDto> findAll() {
		System.out.println("Running findall in serviceImple......");
	List<XworkzEntity> entities = repository.findAll();
	List<XworkzDto> list = new ArrayList<XworkzDto>();
	for(XworkzEntity entity : entities)
	{
		XworkzDto dto = new XworkzDto();
		BeanUtils.copyProperties(entity,dto);
		list.add(dto);
	}
		return list;
	}
	
	@Override
	public boolean sendMail(String to) {
		System.out.println("Running Send mail");
		String portNumber = "587";
		String hostName ="smtp.gmail.com";
		String fromEmail ="suryak14919@gmail.com";
		String password ="Surya@123";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", hostName);
		properties.put("mail.smtp.port", portNumber);
		properties.put("mail.smtp.starttls.enable", true);
		
		
		Session session = Session.getInstance(properties, new Authenticator() {
		
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		
		MimeMessage message = new MimeMessage(session);
		try{
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Registration completed");
			message.setText("Thanks for registring");
			Transport.send(message);
			System.out.println("Mail sent Sucessfully");
		}catch(MessagingException e){
			e.printStackTrace();
		}
		return true;
	}
}
