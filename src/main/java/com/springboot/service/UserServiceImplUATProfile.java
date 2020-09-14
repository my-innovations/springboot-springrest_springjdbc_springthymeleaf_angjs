package com.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserDao;
import com.springboot.service.UserService;

@Service
@Profile("uat")
public class UserServiceImplUATProfile implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;
	
	@Autowired
	@Qualifier("nonProdStrBean")
	private String uatProfileStringBean;
	
	@Autowired
	Environment env;

	@Override
	public String getUserName(Long id) {

		logger.debug("inside UserServiceImplUATProfile.getUserName(-)");
		logger.info("inside UserServiceImplUATProfile.getUserName(-)");
		logger.warn("inside UserServiceImplUATProfile.getUserName(-)");
		logger.error("inside UserServiceImplUATProfile.getUserName(-)");
		
		System.out.println(uatProfileStringBean);
		
		System.out.println(env.getProperty("myproperty"));

		userDao.seeConsoleForDataSourceDetails();

		return "hello from UAT Environment :" + id;
	}

}
