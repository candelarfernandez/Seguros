package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;

public class PolizaDeAuto extends Poliza implements SegurosGenerales {
	public Set<Bien> bienes;
	public Set<Auto> autos;
	public Boolean fueRobado;

	
	public PolizaDeAuto(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima, Double premio) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima, premio);
	
		this.bienes= new HashSet<>();
		this.autos= new HashSet<>();
		this.fueRobado=false;
	}
	
	public Boolean getFueRobado() {
		return fueRobado;
	}

	public void setFueRobado(Boolean fueRobado) {
		this.fueRobado = fueRobado;
	}

	public Set<Auto> getAutos() {
		return autos;
	}

	public void setAutos(Set<Auto> autos) {
		this.autos = autos;
	}

	public Set<Bien> getBienes() {
		return bienes;
	}

	public void setBienes(Set<Bien> bienes) {
		this.bienes = bienes;
	}
	
	
	public Boolean buscarBien(Bien bien) {
		for (Bien bien1 : bienes) {
			if(bien1.equals(bien)) {
				System.out.println("el bien ya existe");
				return true;
			}
		} return false;
	}

	@Override
	public void agregarBienAsegurado(Bien bien) {
		if(buscarBien(bien) == false) {
			this.bienes.add(bien);
			this.autos.add((Auto) bien);
		}
		
	}


}
