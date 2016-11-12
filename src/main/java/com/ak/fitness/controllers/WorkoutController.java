/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import com.ak.fitness.entities.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/workout")
public class WorkoutController {
    
    
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String goToWorkoutPage(ModelMap map, HttpServletRequest request, HttpServletResponse response){
        
        try {
            HttpSession session = request.getSession(false);

            User u = (User) session.getAttribute("user");
            if (u == null) {
                return "index";
            }
        } catch (Exception ex) {
            //user is invalid or session invalid
            Logger.getLogger(WorkoutController.class.getName()).log(Level.SEVERE, null, ex);
            return "index";
        }

        //get the list of workouts for user
        return "workout";
    }
}
