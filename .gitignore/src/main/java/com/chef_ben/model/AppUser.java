package com.chef_ben.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AppUser {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(nullable = false, unique = true)
   private String userName;

   @Column(nullable = false)
   private String password;

   public AppUser(String userName, String password) {
      this.userName = userName;
      this.password = password;
   }
}
