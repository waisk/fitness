/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.services;

import com.ak.fitness.dao.SubscriptionDao;
import com.ak.fitness.dao.UserDao;
import com.ak.fitness.entities.Subscription;
import com.ak.fitness.entities.User;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wais
 */
@Service("registrationService")
public class RegistrationService {

    @Autowired
    UserDao userDao;
    
    @Autowired
    SubscriptionDao subscriptionDao;
    
    public User registerUser(JSONObject json){
        User u = new User();
        String firstName = (String) json.get("firstName");
        String lastName = (String)json.get("lastName");
        String userName = (String)json.get("displayName");
        String email = (String)json.get("email");
        String password = (String)json.get("password");
//        String passwordConfirmation = (String)json.get("passwordConfirmation");
//        String cardHolderName = (String)json.get("cardHolderName");
//        int cardNumber = (Integer)json.get("cardNumber");
//        int cardExpiry = (Integer) json.get("cardExpiry");
//        int cvv = (Integer)json.get("cvv");
        int trainingPackage = (Integer)json.get("trainingPackage");
        
        
        u.setFirstname(firstName);
        u.setLastname(lastName);
        u.setUsername(userName);
        u.setPassword(password);
        
        userDao.createUser(u);
        
        //get username
        User persistedUser = userDao.valiateUserEmail(u.getEmail());
        //create subscription for user
        Subscription subscription = new Subscription();
        subscription.setIduser(persistedUser.getIduser());
        subscription.setPackage1(trainingPackage);
        subscription.setValid(true);
        //set date for subscription too
        subscriptionDao.createSubscription(subscription);
        
        
        return persistedUser;

    }

    public User validateEmail(String email) {
        return userDao.valiateUserEmail(email);
    }

    public void validateCreditCardToken(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User validateUsername(String username) {
        return userDao.validateUsername(username);
    }
}
