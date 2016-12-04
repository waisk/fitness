/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import com.ak.fitness.entities.User;
import com.ak.fitness.entities.Usertoken;
import com.ak.fitness.services.ResetPasswordService;
import com.ak.fitness.services.UserService;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 *
 * @author wais
 */
@Controller
@RequestMapping("/resetPassword")
public class PasswordController {

    @Autowired
    CookieLocaleResolver localeResolver;

    @Autowired
    UserService userService;

    @Autowired
    ResetPasswordService resetPasswordService;

    //TODO receive email in header and reset password
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String resetPassword(ModelMap map,
            @RequestParam(required = true) String token,
            @RequestParam(required = true) String locale,
            HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            if (session.getAttribute("isLoginValid") != null) {
                boolean a = (boolean) session.getAttribute("isLoginValid");

                map.addAttribute("isLoginValid", a);
            }
            //if reach login page from anywhere, close session
            session.invalidate();
        }

        //set locale from localResolver
        localeResolver.setLocale(request, response, new Locale(locale));

        map.addAttribute("token", token);

        request.getSession().setAttribute("userId", null);

        return "resetPassword";
    }

    @ResponseBody
    @RequestMapping(value = "/forgot", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject forgotPassword(@RequestBody JSONObject json, HttpServletRequest request, HttpServletResponse response) {
        //get locale from localResolver
        Locale locale = localeResolver.resolveLocale(request);
        JSONObject jsonResponse = new JSONObject();
        try {
            //1st verify if email exist in PatientLogin
            User u = userService.getUserWithEmail(json.get("email").toString());

            if (u != null) {

                //get last token
                Usertoken ut = userService.getUserLastValidToken(u);

                if (ut == null) {
                    //create token 
                    ut = userService.createToken(u);
                }

                String uri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/fitness/resetPassword";
                try {
                    resetPasswordService.sendForgotPasswordMail(uri, json.get("email").toString(), ut.getToken(), locale);
                } catch (Exception ex) {
                    Logger.getLogger(PasswordController.class.getName()).log(Level.WARNING, null, ex);
                    response.setStatus(500);
                    jsonResponse.put("message", "internal error");
                    return jsonResponse;
                }
                response.setStatus(200);
                jsonResponse.put("message", "email sent successfully");
                return jsonResponse;
            } else {
                String error = "The following email " + json.get("email").toString() + " does not exist.";
                Logger.getLogger(PasswordController.class.getName()).log(Level.WARNING, null, error);
                response.setStatus(500);
                jsonResponse.put("message", "email does not exist");
                return jsonResponse;
            }
        } catch (Exception ex) {
            Logger.getLogger(PasswordController.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(500);
            jsonResponse.put("message", "internal error");
            return jsonResponse;
        }

    }

    @ResponseBody
    @RequestMapping(value = "/ResetNewPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject resetNewPassword(@RequestBody JSONObject json, HttpServletRequest request, HttpServletResponse response) {

        JSONObject jsonResponse = new JSONObject();

        //find Usertoken
        Usertoken ut = userService.findUsertoken(json.get("token").toString());

        if (ut == null) {
            Logger.getLogger(PasswordController.class.getName()).log(Level.SEVERE, null, json.get("token").toString() + " : token invalid or expired");
            response.setStatus(500);
            jsonResponse.put("message", "token expired");
            return jsonResponse;
        } else {

            try {
                resetPasswordService.resetPasswordForToken(ut, json.get("newPassword").toString());
            } catch (Exception ex) {
                Logger.getLogger(PasswordController.class.getName()).log(Level.SEVERE, null, ex);
                response.setStatus(500);
                jsonResponse.put("message", "internal error");
                return jsonResponse;
            }
        }
        
        jsonResponse.put("message", "success");
        return jsonResponse;
    }

}
