package com.springwebservice.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.springwebservice")
@EnableJpaRepositories("com.springwebservice")
public class JPAConfig {

    @Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dnm");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		
		return dataSource;
	}

    @Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan(new String[] {"com.springwebservice.model"});
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", "true");
		
		bean.setJpaProperties(properties);
		
		return bean;
	}

    @Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
	    jpaTransactionManager.setEntityManagerFactory(emf);
	    return jpaTransactionManager;
	   }    

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
