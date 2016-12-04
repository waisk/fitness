/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import com.ak.fitness.services.ContactService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/contact")
public class ContactController {
    
    @Autowired
    ContactService contactService;
    
    @RequestMapping(value="", method = RequestMethod.GET)
    public String getContactPage(ModelMap map, HttpServletRequest request, HttpServletResponse response){
        return "contact";
    }
    
    @ResponseBody
    @RequestMapping(value="", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public JSONObject sendMessage(ModelMap map, @RequestBody JSONObject json, HttpServletRequest request, HttpServletResponse response){
        
        JSONObject jsonResponse = new JSONObject();
        
        try{
            contactService.sendMessage(json);
        }catch(Exception ex){
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(500);
            jsonResponse.put("message", "internalError");
            return jsonResponse;
        }
        
        response.setStatus(200);
        jsonResponse.put("message", "success");
        return jsonResponse;
    }
    
    
}
