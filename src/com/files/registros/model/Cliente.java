package com.files.registros.model;

public class Cliente {
	private Integer id;
	private String nombre;
	private String dni;
	private String direccion;
	private String ciudad;
	private String correo;
	private String telefono;
	
	public Cliente(Integer id, String nombre, String dni, String direccion, String ciudad, String correo,
			String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.correo = correo;
		this.telefono = telefono;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion + ", ciudad="
				+ ciudad + ", correo=" + correo + ", telefono=" + telefono + "]";
	}
}
