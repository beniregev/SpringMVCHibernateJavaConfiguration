package com.chef_ben.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebAppInit extends AbstractAnnotationConfigDispatcherServletInitializer{

   protected Class<?>[] getRootConfigClasses() {
      return new Class[]{RootConfig.class};
   }

   protected Class<?>[] getServletConfigClasses() {
      return new Class[]{WebConfig.class};
   }

   protected String[] getServletMappings() {
      return new String[]{"/"};
   }
}
