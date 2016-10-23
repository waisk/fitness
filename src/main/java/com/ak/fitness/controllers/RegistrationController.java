/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String register(JSONObject json, HttpServletRequest request, HttpServletResponse response) {

        //verify is username(email is unique)
        
        //If not unique, throw error
        
        //If email unique, validate user credit card number
        
        //If not valid, ask user to reenter valid credit card informations
        
        //If valid, register user && open session for new user
        request.getSession();
        
        //set user in the sessino
        request.getSession().setAttribute("userId", null);

        return "redirect:";

    }
}
