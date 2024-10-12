package com.mitocode.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.Persona;

@Repository
@Transactional
public class PersonaDAOImpl extends AbstractDAO implements IPersonaDAO{

	@Override
	public void registrar(Persona per) throws Exception {
		persist(per);		 
	}

	@Override
	public void modificar(Persona per) throws Exception {
		update(per);
		
	}

	@Override
	public void eliminar(Persona per) throws Exception {
		delete(per);
		
	}

	@Override
	public List<Persona> listarTodos() throws Exception {
		TypedQuery<Persona> query = getSession().createQuery("from Persona");
		return query.getResultList();
		/*Criteria criteria = getSession().createCriteria(Persona.class);		
		return (List<Persona>)criteria.list();*/
	}

	@Override
	public Persona listarPorId(int id) throws Exception {
		List<Persona> lista;
		String hql = "FROM Persona Where id = :id";
		
		/*Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		
		lista = query.list();*/
		
		TypedQuery<Persona> query = getSession().createQuery(hql);
		query.setParameter("id", id);
		
		lista = query.getResultList();
				
		Persona per = lista != null && !lista.isEmpty() ? lista.get(0) : new Persona();				
		return per;
	}

}
