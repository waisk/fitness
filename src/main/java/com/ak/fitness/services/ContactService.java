/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.services;

import com.ak.fitness.helper.MailHelper;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wais
 */
@Service("contactService")
@Transactional(value = "transactionManager")
public class ContactService {
    
    @Autowired
    MailHelper mailHelper;

    public void sendMessage(JSONObject json) throws Exception{
    
        //send email to akfitness
        try{
            String firstName = "";
            if(StringUtils.isNotBlank(json.get("firstName").toString())){
                firstName = json.get("firstName").toString();
            }
            String lastName = "";
            if(StringUtils.isNotBlank(json.get("lastName").toString())){
                lastName = json.get("lastName").toString();
            }
            String userEmail = "";
            if(StringUtils.isNotBlank(json.get("email").toString())){
                userEmail = json.get("email").toString();
            }
            String message = "";
            if(StringUtils.isNotBlank(json.get("message").toString())){
                message = json.get("message").toString();
            }
            
            mailHelper.sendContactFormMessageToAdmin(firstName, lastName, userEmail, message);
        }catch(Exception ex){
            throw ex;
        }
    }   
    
    
    
}
