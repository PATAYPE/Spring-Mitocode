package com.mitocode.app.model.entity;

import java.util.Date;

public class Producto {

	private int id;
	private Date createAt;
	private String nombre;
	private Double precio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", createAt=" + createAt + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
}
