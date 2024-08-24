package com.mitocode.app.service;

import java.util.List;

import com.mitocode.app.model.Persona;

public interface IPersonaService {

	void create(Persona persona);
	void update(Persona persona);
	List<Persona> listAll();
	Persona find(Integer id);
	void delete(Integer id);
}
