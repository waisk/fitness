/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.services;

import com.ak.fitness.entities.User;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author wais
 */
@Service("registrationService")
public class RegistrationService {

    //@Autowired
    //UserDao userDao;
    
    public User registerUser(JSONObject json){
        String firstName = (String) json.get("firstName");
        String lastName = (String)json.get("lastName");
        String displayName = (String)json.get("displayName");
        String email = (String)json.get("email");
        String password = (String)json.get("password");
        String passwordConfirmation = (String)json.get("passwordConfirmation");
        String cardHolderName = (String)json.get("cardHolderName");
        int cardNumber = (Integer)json.get("cardNumber");
        int cardExpiry = (Integer) json.get("cardExpiry");
        int cvv = (Integer)json.get("cvv");
        int trainingPackage = (Integer)json.get("trainingPackage");
        
        
        return new User();

    }

    public void validateEmail(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void validateCreditCardToken(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
