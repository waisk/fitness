/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import com.ak.fitness.entities.User;
import com.ak.fitness.services.RegistrationService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author wais
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    
    @Autowired
    RegistrationService registrationService;
    
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public JSONObject register(@RequestBody JSONObject json, HttpServletRequest request, HttpServletResponse response) {

        JSONObject jsonResponse = new JSONObject();
        System.out.println("start registration");
        //verify if email is unique
        User u = null;
        try{
            u = registrationService.validateEmail(json.get("email").toString());
            if(u != null){
//                throw new Exception();
                jsonResponse.put("message", "invalidEmailException");
                return jsonResponse;
            }
        }catch(Exception ex){
            //If not unique, throw error
            jsonResponse.put("message", "internalError");
            return jsonResponse;
//            response.setStatus(400);
//            response.getWriter().write("invalidEmailException");
//            throw ex;
        }
        
        //verify if username is unique
        try{
            u = registrationService.validateUsername(json.get("displayName").toString());
            if(u != null){
//                throw new Exception();
                jsonResponse.put("message", "invalidDisplayNameException");
                return jsonResponse;
            }
        }catch(Exception ex){
            //If not unique, throw error
//            response.setStatus(400);
//            response.getWriter().write("invalidDisplayNameException");
//            throw ex;
            jsonResponse.put("message", "internalError");
            return jsonResponse;
        }
        
        
        //If email and username unique, validate user credit card number
//        try{
//            registrationService.validateCreditCardToken(json.get("creditCardToken").toString());
//        }catch(Exception ex){
//            response.setStatus(400);
//            response.getWriter().write("invalidCreditCard");
//            throw ex;
//        }
        
        try{
            u = registrationService.registerUser(json);
        }catch(Exception ex){
            jsonResponse.put("message", "internalError");
            return jsonResponse;
//            response.setStatus(400);
//            response.getWriter().write("internalError");
//            throw ex;
        }
        //If valid, register user && open session for new user
        HttpSession session = request.getSession();
        
        //set user in the session
        session.setAttribute("user", u);
        
        System.out.println("end of registration");
        response.setStatus(200);
        jsonResponse.put("message", "success");
        return jsonResponse;
        //return "redirect:";
    }
}
