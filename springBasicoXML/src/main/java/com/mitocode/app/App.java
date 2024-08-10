package com.mitocode.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mitocode.app.model.Persona;
import com.mitocode.app.service.IPersonaService;

public class App {

	public static void main(String[] args) {
	
		/*
		 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		 
		IPersonaService service =  (IPersonaService) context.getBean("personaService");
		service.registrar();
		
		Persona persona = (Persona) context.getBean("persona");
		System.out.println(persona);
		
		((ConfigurableApplicationContext)context).close();
		*/
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IPersonaService service =  (IPersonaService) context.getBean("personaService");
		service.registrar();
		
		Persona persona = (Persona) context.getBean("persona");
		System.out.println(persona);
		
		((ConfigurableApplicationContext)context).close();
		context.close();
	}
}
