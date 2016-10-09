/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.controllers;

import com.ak.fitness.entities.User;
import com.ak.fitness.services.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.internal.oxm.conversion.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author wais
 */
@Controller
//@RequestMapping("/akfitness")
public class loginController {
    
    @Autowired
    LoginService loginService;

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
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap map, HttpServletRequest request, HttpServletResponse response) {

        //String urlRedirect = "redirect:" + "";

        request.getSession().invalidate();
        request.getSession().setAttribute("userId", null);

        return "redirect:";

    }
    
    @ResponseBody
    @RequestMapping(value = "/verifyLogin", method = RequestMethod.GET)
    public String verifyLogin(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
            session = null;
        }
        
        String redirect = "";
        
        request.getHeaders("Authorization");
        
        String authorization = request.getHeader("Authorization");
        
        String username = "";
        String password = "";
        
        
        if (authorization != null && authorization.startsWith("Basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.base64Decode(base64Credentials.getBytes()),
                    Charset.forName("UTF-8"));
            // credentials = username:password
            final String[] values = credentials.split(":", 2);
            username = values[0];
            password = values[1];
            
        }
        
        map.addAttribute("isLoginValid", true);

        map.addAttribute("sessionExpired", false);
        boolean isUserValide = false;

        User u = new User();

        try {
            u = loginService.valiateUserCredentials(username, password);
        } catch (Exception ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            request.getSession().setAttribute("isLoginValid", false);
            return "index";
        }
        session = request.getSession(false);
        if (u != null) {
            isUserValide = true;
           
            session.setMaxInactiveInterval(1000);
            //session.setAttribute("userId", u.getIdUser());
            redirect = "training/new/";
            return redirect;

        } else {
            request.getSession().setAttribute("isLoginValid", false);
            return redirect;
        }
    }
    
}
