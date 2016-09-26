/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author wais
 */
@Controller
//@RequestMapping("/akfitness")
public class loginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        map.addAttribute("isLoginValid", true);
        //map.addAttribute("supplierPovOnlineId", 0);

        HttpSession session = request.getSession(false);

        if (session != null) {
            if (session.getAttribute("isLoginValid") != null) {
                boolean a = (boolean) session.getAttribute("isLoginValid");

                map.addAttribute("isLoginValid", a);
            }
            //if reach login page from anywhere, close session
            session.invalidate();
        }

        request.getSession().setAttribute("userId", null);

        return "index";
    }
    
}
