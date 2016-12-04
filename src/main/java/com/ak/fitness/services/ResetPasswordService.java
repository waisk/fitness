/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.services;

import com.ak.fitness.dao.UserDao;
import com.ak.fitness.dao.UsertokenDao;
import com.ak.fitness.entities.User;
import com.ak.fitness.entities.Usertoken;
import com.ak.fitness.helper.MailHelper;
import com.ak.fitness.util.EncryptionUtil;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wais
 */
@Service("resetPasswordService")
@Transactional(value="transactionManager")
public class ResetPasswordService {
 
    @Autowired
    MailHelper mailHelper;
    
    @Autowired
    UsertokenDao usertokenDao;
    
    @Autowired
    UserDao userDao;
    
    public void sendForgotPasswordMail(String uri, String email, String token, Locale locale) throws Exception{
    
        try{
            mailHelper.sendForgotPasswordMailToUser(uri, email, token, locale);
        }catch(Exception ex){
            Logger.getLogger(ResetPasswordService.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    
    public void resetPasswordForToken(Usertoken ut, String newPassword) throws Exception {

        try {
            Date validatedOn = new Date();
            ut.setValidatedOn(validatedOn);
            usertokenDao.updateUserToken(ut);

            User u = ut.getIdUser();
            //encrypt password before saving into db
            String encryptedPassword = EncryptionUtil.encrypt(newPassword);
            u.setPassword(encryptedPassword);
            userDao.updateUser(u);
        } catch (Exception ex) {
            Logger.getLogger(ResetPasswordService.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
