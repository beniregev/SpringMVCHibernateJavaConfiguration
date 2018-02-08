package com.chef_ben.service.impl;

import com.chef_ben.model.AppUser;
import com.chef_ben.service.AppUserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppUserServiceImpl implements AppUserService {

   @Autowired
   SessionFactory sessionFactory;

   @Transactional
   public void insertUser(AppUser appUser) {
      sessionFactory.getCurrentSession().save(appUser);
   }
}
