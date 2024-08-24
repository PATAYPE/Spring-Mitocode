package com.mitocode.app.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.app.model.Persona;

@Repository
public class PersonaDAOImpl extends JdbcDaoSupport implements IPersonaDAO {

	// @Autowired
	// private DataSource dataSource;

	@Autowired
	public PersonaDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public void create(Persona persona) {
		String sql = "INSERT INTO PERSONA (NOMBRES, APELLIDOS) VALUES (?, ?)";

		/*
		 * try (Connection cx = dataSource.getConnection()) { PreparedStatement ps =
		 * cx.prepareStatement(sql); ps.setString(1, persona.getNombres());
		 * ps.setString(2, persona.getApellidos()); ps.executeUpdate(); ps.close();
		 * 
		 * } catch (SQLException e) { throw new RuntimeException(e); }
		 */
		
		this.getJdbcTemplate().update(sql, new Object[] { persona.getNombres(), persona.getApellidos() });
	}

	@Override
	public void update(Persona persona) {
		String sql = "UPDATE persona SET nombres = ?, apellidos = ? WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] { persona.getNombres(), persona.getApellidos(), persona.getId() });
	}

	@Override
	public List<Persona> listAll() {
		String sql = "SELECT id, nombres, apellidos FROM Persona ORDER BY nombres, apellidos";
		List<Persona> lista = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Persona>(Persona.class));
		return lista;
	}

	@Override
	public Persona find(Integer id) {
		String sql = "SELECT id,nombres,apellidos FROM persona WHERE codigo = ?";
		Persona objeto = (Persona) getJdbcTemplate().queryForObject(sql, new Object[] {id} , new BeanPropertyRowMapper<Persona>(Persona.class));
		return objeto;
	}

	@Transactional("transactionManager")
	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM persona WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] { id });
		
		sql = "UPDATE persona SET nombres = ?, apellidos = ?, WHERE id = ?";	
		getJdbcTemplate().update(sql, new Object[] { null, null, id });
	}

}
