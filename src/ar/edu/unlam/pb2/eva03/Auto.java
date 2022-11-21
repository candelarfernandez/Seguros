package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class Auto extends Bien{
	private String marca;
	private String modelo;
	private Integer anio;
	
	public Auto(String marca, String modelo, Integer anio, Double SUMA_ASEGURADA) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(anio, marca, modelo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		return Objects.equals(anio, other.anio) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo);
	}
	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + "]";
	}
	
	

}
