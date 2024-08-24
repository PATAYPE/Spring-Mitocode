package com.mitocode.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.app.model.Persona;
import com.mitocode.app.service.IPersonaService;
import com.mitocode.app.service.PersonaServiceImpl;

@ComponentScan
public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		IPersonaService service = (IPersonaService) context.getBean(PersonaServiceImpl.class);
		
		Persona per = new Persona();
		per.setId(29);
		per.setNombres("MitoX");
		per.setApellidos("CodeX");
		
		service.create(per);		
		
		service.listAll().forEach(x -> System.out.println(x.getApellidos()));
	}
}
