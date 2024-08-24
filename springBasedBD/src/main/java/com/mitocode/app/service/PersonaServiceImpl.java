package com.mitocode.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.app.dao.IPersonaDAO;
import com.mitocode.app.model.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired		
	private IPersonaDAO dao;
	
	@Override
	public void create(Persona persona) {		
		dao.create(persona);
	}

	@Override
	public void update(Persona persona) {
		dao.update(persona);
		
	}

	@Override
	public List<Persona> listAll() {
		return dao.listAll();
	}

	@Override
	public Persona find(Integer id) {
		return dao.find(id);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

}
