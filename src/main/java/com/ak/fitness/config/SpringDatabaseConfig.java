package com.ak.fitness.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.support.nativejdbc.CommonsDbcpNativeJdbcExtractor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author wais
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:jdbc.properties" })
@ComponentScan("com.ak.fitness")
public class SpringDatabaseConfig extends WebMvcConfigurerAdapter{
    
   @Autowired
   private Environment env;
   
   @Bean
   @Qualifier("sessionFactory")
   public SessionFactory sessionFactory() {
      SessionFactory sessionFactory = localSessionFactoryBean().getObject();
      return sessionFactory;
   }
   
 
   @Bean
   @Qualifier("localSessionFactoryBean")
   public LocalSessionFactoryBean localSessionFactoryBean() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(restDataSource());
      sessionFactory.setPackagesToScan(new String[] { "com.ak.fitness.entities" });
      sessionFactory.setHibernateProperties(hibernateProperties());
 
      return sessionFactory;
   }
   
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }
    
    
   @Bean
   public DataSource restDataSource() {
      BasicDataSource restAkFitnessDataSource = new BasicDataSource();
      restAkFitnessDataSource.setDriverClassName(env.getProperty("jdbc.akfitness.driverClassName"));
      restAkFitnessDataSource.setUrl(env.getProperty("jdbc.akfitness.url"));
      restAkFitnessDataSource.setDefaultCatalog(env.getProperty("jdbc.akfitness.schema"));
      restAkFitnessDataSource.setUsername(env.getProperty("jdbc.akfitness.user"));
      restAkFitnessDataSource.setPassword(env.getProperty("jdbc.akfitness.pass"));
      restAkFitnessDataSource.setInitialSize(Integer.parseInt(env.getProperty("jdbc.akfitness.initialSize")));
      restAkFitnessDataSource.setAccessToUnderlyingConnectionAllowed(true);
      restAkFitnessDataSource.setValidationQuery(env.getProperty("jdbc.akfitness.validationQuery"));
      restAkFitnessDataSource.setTestOnBorrow(true);
      restAkFitnessDataSource.setMaxActive(-1);
      restAkFitnessDataSource.setMaxWait(500);
 
      return restAkFitnessDataSource;
   } 
 
   @Bean
   @Autowired
   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);
 
      return txManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
   
   @Bean
   public CommonsDbcpNativeJdbcExtractor jdbcExtractor(){
       return new CommonsDbcpNativeJdbcExtractor();
   }
 
}
