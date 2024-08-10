package com.mitocode.app.service;

import java.util.List;

import com.mitocode.app.model.Persona;

public interface IPersonaService {

	public List<Persona> listar();
	
	public void registrar();
}
