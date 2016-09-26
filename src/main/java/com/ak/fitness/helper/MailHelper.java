/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.helper;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailHelper {

    @Autowired
    private MailSender mailSender;
   
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
    
    public void sendForgotPasswordMail(JSONObject json) {

        SimpleMailMessage message = new SimpleMailMessage();
        String userEmail = json.get("email").toString();
        message.setFrom("akfitness@gmail.com");
        message.setTo("khedriwais@hotmail.com");
        message.setSubject("User forgot password");
        message.setText("email: " + userEmail + "\n"
        );
        mailSender.send(message);
        
        sendForgotPasswordMailToUser(userEmail);
    }
    
    private void sendForgotPasswordMailToUser(String userEmail){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("akfitness@gmail.com");
        message.setTo(userEmail);
        message.setSubject("AKFitness: Forgotten Password");
        message.setText("Hi: \n\n"
                        + "Please click on this link to reset your password. \n\n"
                        + "Thank you."
                );
        mailSender.send(message);
    }
}
