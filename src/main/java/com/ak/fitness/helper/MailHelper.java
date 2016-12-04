/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.helper;

import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;


@Component
public class MailHelper {

    @Autowired
    private MailSender mailSender;
    
    @Autowired
    private ResourceBundleMessageSource messageSource;
   
    public void sendRegistrationMail(JSONObject json) {

        SimpleMailMessage message = new SimpleMailMessage();
        
        String storePhone = json.get("storePhone").toString();
        if (StringUtils.isNotBlank(json.get("ext").toString())) {
            storePhone += " ext. "+ json.get("ext").toString(); 
        }

        message.setFrom("akfitness@gmail.com");
        message.setTo("akfitness@gmail.com");
        message.setSubject("AKFitness");
        message.setText("firstName: "+json.get("firstName")+"\n"
                + "lastName: "+json.get("lastName")+"\n"
                + "email: "+json.get("email")+"\n"
                + "password: "+json.get("password")+"\n"
                + "company: "+json.get("company")+"\n"
        );
        mailSender.send(message);
        
        
        sendConfirmationMailToUser(json.get("email").toString());
        
    }
    
    private void sendConfirmationMailToUser(String userEmail){
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setFrom("akfitness@gmail.com");
        message.setTo(userEmail);
        message.setSubject("akfitness Registration");
        message.setText("Welcome to AKFitness: \n\n"
                        + "We received your registration and you will be noticed once your account has been created. \n\n"
                        + "Thank you."
                );
        
        mailSender.send(message);
                
    }
    
    public void sendForgotPasswordMailToUser(String uri, String email, String token, Locale locale) throws Exception{
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("akfitness@gmail.com");
        message.setTo(email);
        message.setSubject("AKFitness: " + messageSource.getMessage("ResetYourPassword", null, locale));
        message.setText(messageSource.getMessage("Hi", null, locale)+": \n\n"
                        + messageSource.getMessage("ClickLinkPassword", null, locale)+ " " +uri+"/"+"?token="+token+"&locale="+locale.getLanguage()+"\n\n"
                        + messageSource.getMessage("ThankYou", null, locale)
                );
        mailSender.send(message);
    }
    
    
    
    //Send to 
    public void sendContactFormMessageToAdmin(String firstName, String lastName, String userEmail, String contactMessage){
        
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setFrom(userEmail);
        message.setTo("akfitness@gmail.com");
        message.setSubject("AKFitness: Contact Message");
        message.setText(
                "From: " +firstName + " " + lastName +  "\n\n"
                + contactMessage
                );
        mailSender.send(message);
    }
}
