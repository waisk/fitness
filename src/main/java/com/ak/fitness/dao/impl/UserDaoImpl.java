/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.dao.impl;

import com.ak.fitness.dao.UserDao;
import com.ak.fitness.entities.User;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wais
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

    @Override
    public User valiateUserCredentials(String username, String password) {
        SQLQuery query = getAppropriateSessionNew().createSQLQuery("select distinct u.idUser"
                + " from user u"
                + " where (u.email ='" + username + "' OR u.username ='" + username + "') AND u.password ='" + password + "';"
        );

        query.setResultTransformer(Transformers.aliasToBean(User.class));

        return (User) query.uniqueResult();
    }
    
}