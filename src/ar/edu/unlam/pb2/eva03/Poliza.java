package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Objects;

public class Poliza {
	public Integer numeroDePoliza;
	public Double sumaAsegurada;
	public Double prima;
	private Double premio;
	private Persona asegurado;
	
	public Poliza(Integer numPoliza, Persona asegurado, Double sumaAsegurada, Double prima,
			Double premio) {
		super();
		this.numeroDePoliza = numPoliza;
		this.asegurado = asegurado;
		this.sumaAsegurada = sumaAsegurada;
		this.prima = prima;
		this.premio = premio;
	}

	public Integer getNumeroDePoliza() {
		return numeroDePoliza;
	}

	public void setNumeroDePoliza(Integer numeroDePoliza) {
		this.numeroDePoliza = numeroDePoliza;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public Double getPrima() {
		return prima;
	}

	public void setPrima(Double prima) {
		this.prima = prima;
	}

	public Double getPremio() {
		return premio;
	}

	public void setPremio(Double premio) {
		this.premio = premio;
	}

	public Persona getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(Persona asegurado) {
		this.asegurado = asegurado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asegurado, numeroDePoliza, premio, prima, sumaAsegurada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poliza other = (Poliza) obj;
		return Objects.equals(asegurado, other.asegurado) && Objects.equals(numeroDePoliza, other.numeroDePoliza)
				&& Objects.equals(premio, other.premio) && Objects.equals(prima, other.prima)
				&& Objects.equals(sumaAsegurada, other.sumaAsegurada);
	}

	public Boolean fueRobado() {
		return true;
	}

	public Boolean tuvoAlgunAccidente() {
		return true;
	}
	

}
