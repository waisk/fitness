/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.dao.impl;

import com.ak.fitness.dao.UsertokenDao;
import com.ak.fitness.entities.Usertoken;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wais
 */
@Repository("usertokenDao")
public class UsertokenDaoImpl extends AbstractDao<Integer, Usertoken> implements UsertokenDao{

    @Override
    public Usertoken getUserLastToken(Integer iduser) {
        SQLQuery query = getAppropriateSessionNew().createSQLQuery("select distinct *"
                + " from usertoken ut"
                + " where ut.idUser ='" + iduser + ";"
        );

        query.setResultTransformer(Transformers.aliasToBean(Usertoken.class));
        
        return (Usertoken) query.uniqueResult();
    }

    @Override
    public Usertoken persistToken(Usertoken ut) {
        persist(ut);
        return ut;
    }

    @Override
    public Usertoken findUsertoken(String token) {
        SQLQuery query = getAppropriateSessionNew().createSQLQuery("select distinct *"
                + " from usertoken ut"
                + " where ut.token ='" + token + ";"
        );

        query.setResultTransformer(Transformers.aliasToBean(Usertoken.class));
        
        return (Usertoken) query.uniqueResult();
    }

    @Override
    public void updateUserToken(Usertoken ut) {
        
        update(ut);
    }
    
}
