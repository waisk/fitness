/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.dao;

import com.ak.fitness.entities.User;

/**
 *
 * @author wais
 */
public interface UserDao {
    
    public User valiateUserCredentials(String username, String password);

    public User valiateUserEmail(String email);

    public User validateUsername(String username);

    public User createUser(User u);

    public void updateUser(User u);

}
