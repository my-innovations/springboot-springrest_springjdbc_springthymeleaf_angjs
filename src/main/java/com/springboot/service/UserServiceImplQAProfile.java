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
@Profile("qa")
public class UserServiceImplQAProfile implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;
	
	@Autowired
	@Qualifier("nonProdStrBean")
	private String qaProfileStringBean;
	
	@Autowired
	Environment env;

	@Override
	public String getUserName(Long id) {
		logger.debug("inside UserServiceImplQAProfile.getUserName(-)");
		logger.info("inside UserServiceImplQAProfile.getUserName(-)");
		logger.warn("inside UserServiceImplQAProfile.getUserName(-)");
		logger.error("inside UserServiceImplQAProfile.getUserName(-)");
		
		System.out.println(qaProfileStringBean);
		
		System.out.println(env.getProperty("myproperty"));

		userDao.seeConsoleForDataSourceDetails();

		return "hello from QA ENV :" + id;
	}
}
