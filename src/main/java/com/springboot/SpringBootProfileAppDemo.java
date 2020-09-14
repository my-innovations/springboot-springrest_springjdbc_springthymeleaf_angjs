package com.springboot;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

// For .war packaging
//java -jar springboot_profile_demo.war .

//For .jar packaging
//java -jar springboot_profile_demo.jar .

@SpringBootApplication
// @Controller // ok
// @RestController //ok
public class SpringBootProfileAppDemo extends SpringBootServletInitializer {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootProfileAppDemo.class);
	}

	public static void main(String[] args) {

		// SpringApplication.run(SpringBootWebApp.class, args);
		// OR
		// customize start up here
		SpringApplication app = new SpringApplication(SpringBootProfileAppDemo.class);
		// app.setLogStartupInfo(false);
		// app.setBannerMode(Banner.Mode.OFF);
		// app.setBanner(new ImageBanner(new UrlResource("spring-boot.png")));
		app.run(args);
	}
	
	//we can move below code to config file.
	@Bean(name="prodStrBean")
	@Profile("prod")
	public String createProdBean() {
		return new String("prod str bean has been created ");
	}
	
	@Bean(name="nonProdStrBean")
	@Profile("!prod")
	public String notProdBean() {
		return new String("not prod str bean has benn created");
	}

}
