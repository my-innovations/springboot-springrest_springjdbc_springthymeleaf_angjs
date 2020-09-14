package com.springboot.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.UserService;

@RestController
public class UserRestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	@Autowired
	Environment env;

	@Value("${logging.file}")
	private String logFile;

	@Value("${myproperty}")
	private String myProperty;

	@RequestMapping("/user/{id}")
	public String getUserName(@PathVariable("id") Long id) {
		logger.debug("inside UserRestController.getUserName(-)");
		logger.info("inside UserRestController.getUserName(-)");
		logger.warn("inside UserRestController.getUserName(-)");
		logger.error("inside UserRestController.getUserName(-)");
		System.out.println(env.getProperty("myProperty"));
		String greeting = userService.getUserName(id) + " and log file name=" + logFile + " and property vame=" + myProperty;
		return greeting;
	}
	
	
	

}
