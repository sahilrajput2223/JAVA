package com.sahil.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.sahil.user"})
@EnableTransactionManagement
public class JpaConfigration {

	@Bean(name = "entityManagerFactory")
	public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("SpringDB");
		return bean;
	}
	
	@Bean(name = "transactionManager")
	public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactoryBean) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean);
		return jpaTransactionManager;
	}
}
