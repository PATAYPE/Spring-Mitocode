package com.mitocode.app.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.app.model.dao.IProductoDao;
import com.mitocode.app.model.entity.Producto;

@Service
public class ProductoaServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao dao;
	
	@Override
	public void crear(Producto producto) {
		dao.crear(producto);
		
	}

}
