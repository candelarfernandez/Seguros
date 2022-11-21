package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public class Persona {
	private String nombre;
	private Integer dni;
	private Integer edad;
	private TipoDeBeneficiario tipo;
	
	public Persona(String nombre, Integer dni, Integer edad, TipoDeBeneficiario tipo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.tipo=tipo;
	}
	
	public TipoDeBeneficiario getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeBeneficiario tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni, edad, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(edad, other.edad)
				&& Objects.equals(nombre, other.nombre);
	}
	

}
