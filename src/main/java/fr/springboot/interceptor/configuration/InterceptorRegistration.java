package fr.springboot.interceptor.configuration;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

import fr.springboot.interceptor.implement.InterceptorImplement;

@Configuration
public class InterceptorRegistration implements HibernatePropertiesCustomizer {

	@Autowired
	InterceptorImplement interceptor;
	
	@Override
	public void customize(Map<String,Object> hibernateProperties) {
		hibernateProperties.put("hibernate.session_factory.interceptor", interceptor);
	}
}
