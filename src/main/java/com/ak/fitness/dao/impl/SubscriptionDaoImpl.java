/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.dao.impl;

import com.ak.fitness.dao.SubscriptionDao;
import com.ak.fitness.entities.Subscription;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wais
 */
@Repository("subscriptionDao")
public class SubscriptionDaoImpl extends AbstractDao<Integer, Subscription> implements SubscriptionDao{

    @Override
    public void createSubscription(Subscription subscription) {
        persist(subscription);
        
    }
    
}
