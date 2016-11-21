/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import com.ak.fitness.entities.User;
import com.ak.fitness.services.PaymentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author wais
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/{trainingPackageNo}", method = RequestMethod.GET)
    public String doPayment(@PathVariable("trainingPackageNo") String trainingPackageNo, HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        User u = (User) session.getAttribute("user");

        //redirects here after Paypal successful
        //1.
        //2.login in user if not logged in (user must be logged in => unless session timeout)
        if (session == null && u == null) {
            //login user
        }

        //add new subscription to user 
        if (u != null) {
            paymentService.createSubscription(u, Integer.valueOf(trainingPackageNo));
        }

        //3.redirect to workout page
        return "workout";
    }

    @RequestMapping(value = "/cancel/{trainingPackageNo}", method = RequestMethod.GET)
    public String paymentCancelled(ModelMap map, @PathVariable("trainingPackageNo") String trainingPackageNo, HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        User u = (User) session.getAttribute("user");
        
        //map.addAttribute("user", u);
        map.addAttribute("trainingPackage", trainingPackageNo);
        //if sets to 2 => means cancelled
        map.addAttribute("isPaymentCancelled", true);
        return "services";
    }
}
