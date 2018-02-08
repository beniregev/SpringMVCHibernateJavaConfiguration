package com.chef_ben.config;

import com.chef_ben.model.AppUser;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

   @Autowired
   private ApplicationContext appContext;

   @Bean(name = "DataSource")
   public HikariDataSource dataSourceWindowLinuxMac() {
      HikariDataSource dataSource = new HikariDataSource();
      dataSource.setDriverClassName("org.postgresql.Driver");
      dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/test_db");

      //dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
      //dataSource.setConnectionTimeout(30000);
      //dataSource.setAutoCommit(true);
      //dataSource.setIdleTimeout(60000);
      //dataSource.setMaxLifetime(1800000);
      //dataSource.setLeakDetectionThreshold(15000);
      //dataSource.setMaximumPoolSize(20);
      //dataSource.setPoolName(serviceID+"_DBPool");
      //dataSource.setRegisterMbeans(true);

      dataSource.addDataSourceProperty("databaseName", "test_db");
      dataSource.addDataSourceProperty("portNumber", "5432");
      dataSource.addDataSourceProperty("serverName", "127.0.0.1");
      dataSource.addDataSourceProperty("user", "postgres");
      dataSource.addDataSourceProperty("password", "admin");

      return dataSource;
   }

   @Bean
   public HibernateTransactionManager transactionManager() {
      HibernateTransactionManager manager = new HibernateTransactionManager();
      manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
      return manager;
   }

   @Bean
   public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
      LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
      localSessionFactoryBean.setDataSource((DataSource) appContext.getBean("DataSource"));
      localSessionFactoryBean.setAnnotatedClasses(
            AppUser.class
      );

      Properties properties = new Properties();
      properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
      //properties.put("hibernate.current_session_context_class","thread");
      properties.put("hibernate.hbm2ddl.auto","create-drop");
      properties.put("hibernate.hbm2ddl.import_files", "import_initial_data.sql");
      properties.put("hibernate.show_sql","true");

      localSessionFactoryBean.setHibernateProperties(properties);
      return localSessionFactoryBean;
   }
}
