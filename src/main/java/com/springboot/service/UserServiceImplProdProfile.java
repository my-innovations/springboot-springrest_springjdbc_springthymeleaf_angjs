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
@Profile("prod")
public class UserServiceImplProdProfile implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;
	
	@Autowired
	@Qualifier("prodStrBean")
	private String prodProfileStringBean;
	
	@Autowired
	Environment env;

	@Override
	public String getUserName(Long id) {

		logger.debug("inside UserServiceImplProdProfile.getUserName(-)");
		logger.info("inside UserServiceImplProdProfile.getUserName(-)");
		logger.warn("inside UserServiceImplProdProfile.getUserName(-)");
		logger.error("inside UserServiceImplProdProfile.getUserName(-)");
		
		System.out.println(env.getProperty("myproperty"));
		
		System.out.println(prodProfileStringBean);

		userDao.seeConsoleForDataSourceDetails();

		return "hello from PROD ENV :" + id;
	}
}