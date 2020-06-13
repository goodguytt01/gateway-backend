package com.innovation.emall.api.service;

import com.innovation.emall.api.service.common.config.BaseZookeeper;
import com.innovation.emall.api.service.servlet.JlbGwDispatchServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
import java.util.jar.JarFile;

/**
 * The type Client mobile application.
 *
 * @author edward
 */
@RestController
@SpringBootApplication
@ServletComponentScan(basePackages = " com.innovation.emall.api.service.servlet")
public class ClientMobileApplication {
    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMobileApplication.class);

    /**
     * Hello string.
     *
     * @return the string
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }


    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new JlbGwDispatchServlet(),"/api/dubbo/*");
        return registrationBean;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws Exception{
        SpringApplication application = new SpringApplication(ClientMobileApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        LOGGER.info("Client mobile started!!!");
    }
}
