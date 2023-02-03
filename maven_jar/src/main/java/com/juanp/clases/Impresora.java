package com.juanp.clases;

public class Impresora {

	private String nombre;
	private Integer anio;
	private Double peso;

	public Impresora(String nombre, Integer anio, Double peso) {
		this.nombre = nombre;
		this.anio = anio;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
}
