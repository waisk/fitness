/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.dao;

import com.ak.fitness.entities.Usertoken;

/**
 *
 * @author wais
 */
public interface UsertokenDao {

    public Usertoken getUserLastToken(Integer iduser);

    public Usertoken persistToken(Usertoken ut);

    public Usertoken findUsertoken(String token);

    public void updateUserToken(Usertoken ut);
    
    
}
