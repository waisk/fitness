/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import com.ak.fitness.entities.User;
import com.ak.fitness.rest.client.RestClient;
import com.ak.fitness.services.PaymentService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author wais
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    private static final Logger LOGGER = Logger.getLogger(PaymentController.class.getName());

    @Autowired
    PaymentService paymentService;
    
    @Autowired
    RestClient restClient;

    @RequestMapping(value = "/{trainingPackageNo}", method = RequestMethod.GET)
    public String doPayment(@PathVariable("trainingPackageNo") String trainingPackageNo,@RequestParam String tx, HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = null;
        User u = null;
        try {
            session = request.getSession(false);
            //what happens if user lose session between paypal and here
            //LOGGER.log(Level.INFO, null, "Subscription failed for user : recreate a subscription for userID = "+u.getIduser()+" and trainingPackage = "+trainingPackage);
            u = (User) session.getAttribute("user");

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, "NO session or no user : session = " + session + " and user = " + u.getIduser());
            return "services";
        }
        
        //Need to verify the tx by making a call to PayPal and sending my tokenId (w-FNzou8a6WaHwCQxpOR9mzzJyYdOwE9ToF64iOLhcP3iSYQ8Rhhttzg5Ji)
        //Make a POST call
        if (restClient.isPaypalTokenValid(tx) == true) {

            //add new subscription to user 
            if (u != null) {
                paymentService.createSubscription(u, Integer.valueOf(trainingPackageNo));
            }

            //3.redirect to workout page
            return "workout";
        }else{
            //token invalid
            
            //something went wrong
            //payment did not go through, contact us if there is any problem
            
            return "services";
        }
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
