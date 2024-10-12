package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Persona;

public interface IPersonaDAO {
	
	Persona save(Persona persona);
	Persona update(Persona persona);
	List<Persona> list();
	Persona findById(Integer id);
	void delete(Integer id);
}
