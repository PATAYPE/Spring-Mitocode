package com.mitocode.app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.mitocode.app.model.entity.Producto;

@Repository
public class IProductoDaoImpl   implements IProductoDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public void crear(Producto producto) {

		String sql = "INSERT INTO PRODUCTOS (NOMBRE, PRECIO) VALUES (?, ?)";

		try (Connection cx = dataSource.getConnection()) {

			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, producto.getNombre());
			ps.setDouble(2, producto.getPrecio());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		System.out.println("producto creado " + producto.getNombre());

	}

}
