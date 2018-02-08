package com.chef_ben.controller;

import com.chef_ben.model.AppUser;
import com.chef_ben.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Binyamin Regev
 * Created by Binyamin Regev on 05-Feb-2018
 */
@Controller
public class HomeController {

   @Autowired
   AppUserService appUserService;


   @RequestMapping(value = "/")
   public String home() {
      return "home";
   }

   @RequestMapping(value = "/addUser")
   public String addUser() {
      appUserService.insertUser(new AppUser("Binyamin", "begin"));
      return "home";
   }
}
