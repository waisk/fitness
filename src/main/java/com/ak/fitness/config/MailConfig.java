/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author wais
 */
@Configuration
@PropertySource(value = {"classpath:mail.properties"})
@ComponentScan("com.ak.fitness")
public class MailConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSenderImpl mailSender() {

        JavaMailSenderImpl mailSender= new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mail.host"));
        mailSender.setPort(Integer.parseInt(env.getProperty("mail.port")));
        mailSender.setUsername(env.getProperty("mail.userName"));
        mailSender.setPassword(env.getProperty("mail.password"));
        
        mailSender.setJavaMailProperties(mailProperties());
        return mailSender;
    }

    private Properties mailProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", env.getRequiredProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable", env.getRequiredProperty("mail.smtp.starttls.enable"));
        return properties;
    }
}
