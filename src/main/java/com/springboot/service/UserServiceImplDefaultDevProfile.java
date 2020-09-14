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
@Profile("default")
public class UserServiceImplDefaultDevProfile implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;
	
	@Autowired
	@Qualifier("nonProdStrBean")
	private String defaultProfileStrBean;
	
	@Autowired
	Environment env;

	@Override
	public String getUserName(Long id) {

		logger.debug("inside UserServiceImplDefault.getUserName(-)");
		logger.info("inside UserServiceImplDefault.getUserName(-)");
		logger.warn("inside UserServiceImplDefault.getUserName(-)");
		logger.error("inside UserServiceImplDefault.getUserName(-)");
		
		System.out.println(defaultProfileStrBean);
		
		System.out.println(env.getProperty("myproperty"));

		userDao.seeConsoleForDataSourceDetails();

		return "hello from Default ENV:" + id;
	}
}
