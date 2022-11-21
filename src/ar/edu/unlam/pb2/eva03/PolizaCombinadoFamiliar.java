package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PolizaCombinadoFamiliar extends Poliza implements SegurosGenerales, SegurosDeVida{

	private Set<Bien> bienes;
	private Set<Persona> beneficiarios;
	
	public PolizaCombinadoFamiliar(Integer numPoliza, Persona asegurado, Double sumaAsegurada, Double prima,
			Double premio) {
		super(numPoliza, asegurado, sumaAsegurada, prima, premio);
		this.bienes= new HashSet<>();
		this.beneficiarios= new HashSet<>();
	}
	
	public Set<Bien> getBienes() {
		return bienes;
	}

	public void setBienes(Set<Bien> bienes) {
		this.bienes = bienes;
	}

	public Set<Persona> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(Set<Persona> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

		
	public Boolean buscarBienes(Bien bien) {
		for (Bien bien1 : bienes) {
			if(bien1.equals(bien)) {
				return true;
			}
		}return false;
	}



	@Override
	public void agregarBienAsegurado(Bien bien) {
		if(buscarBienes(bien) == false) {
			this.bienes.add(bien);
		}
		
	}


	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario tipo) {
		this.beneficiarios.add(persona);
	}

	@Override
	public Integer obtenerCantidadBeneficiarios() {
		// TODO Auto-generated method stub
		return this.getBeneficiarios().size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(beneficiarios, bienes);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolizaCombinadoFamiliar other = (PolizaCombinadoFamiliar) obj;
		return Objects.equals(beneficiarios, other.beneficiarios) && Objects.equals(bienes, other.bienes);
	}
	

	
}
