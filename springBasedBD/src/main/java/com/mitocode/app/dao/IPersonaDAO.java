package com.mitocode.app.dao;

import java.util.List;

import com.mitocode.app.model.Persona;

public interface IPersonaDAO {

	void create(Persona persona);
	void update(Persona persona);
	List<Persona> listAll();
	Persona find(Integer id);
	void delete(Integer id);
}
