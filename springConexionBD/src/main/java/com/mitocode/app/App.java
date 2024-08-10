package com.mitocode.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.app.model.entity.Producto;
import com.mitocode.app.model.repository.IProductoService;
import com.mitocode.app.model.repository.ProductoaServiceImpl;

public class App {

	
	public static void main(String [] arg) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		IProductoService service = context.getBean(ProductoaServiceImpl.class);
		
		Producto pro = new Producto();
		pro.setId(11);
		pro.setNombre("Mesa Comedor");
		pro.setPrecio(1500.0);
		
		service.crear(pro);
	}
}

