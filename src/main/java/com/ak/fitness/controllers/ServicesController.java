/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author wais
 */
@Controller
@RequestMapping("/services")
public class ServicesController {
    
    @RequestMapping(value = "", method=RequestMethod.GET)
    public String getListTrainingServices(ModelMap map, HttpServletRequest request, HttpServletResponse response){
        
        return "services";
    }
}
