package com.mitocode.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.app.model.Persona;
import com.mitocode.app.service.IPersonaService;
import com.mitocode.app.service.PersonaServiceImpl;


public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IPersonaService service = (IPersonaService) context.getBean(PersonaServiceImpl.class);
		
		Persona per = new Persona();
		per.setId(30);
		per.setNombres("MitoXxx");
		per.setApellidos("CodeXxx");
		
		//service.update(per);
		service.delete(per.getId());
		
		service.listAll().forEach(x -> System.out.println(x.getApellidos()));
	}
}
