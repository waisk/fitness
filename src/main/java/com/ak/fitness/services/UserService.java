/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.services;

import com.ak.fitness.dao.UserDao;
import com.ak.fitness.dao.UsertokenDao;
import com.ak.fitness.entities.User;
import com.ak.fitness.entities.Usertoken;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wais
 */
@Service("userService")
@Transactional(value = "transactionManager")
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UsertokenDao usertokenDao;

    public User getUserWithUsername(String username) {
        try {
            User u = userDao.validateUsername(username);
            return u;
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Usertoken getUserLastValidToken(User u) {
        try {
            Usertoken ut = usertokenDao.getUserLastToken(u.getIduser());
            if (isTokenValid(ut)) {
                return ut;
            }
            return null;
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Usertoken createToken(User u) {

        try {

            Usertoken ut = new Usertoken();
            ut.setToken(UUID.randomUUID().toString());
            ut.setDateSent(new Date());
            ut.setIdUser(u);
            return usertokenDao.persistToken(ut);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private boolean isTokenValid(Usertoken ut) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(ut.getDateSent());
        cal.add(Calendar.DATE, 1);
        Date maxDelay = cal.getTime();

        return new Date().before(maxDelay);
    }

    public Usertoken findUsertoken(String token) {
        try {
            Usertoken ut = usertokenDao.findUsertoken(token);

            if (isTokenValid(ut)) {
                return ut;
            }return null;
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
