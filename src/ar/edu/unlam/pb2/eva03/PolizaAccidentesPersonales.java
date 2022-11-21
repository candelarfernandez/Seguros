package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;

public class PolizaAccidentesPersonales extends Poliza implements SegurosDeVida {
	public Set<Persona> beneficiarios;
	private Boolean tuvoAlgunAccidente;

	public PolizaAccidentesPersonales(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima, Double premio) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima, premio);
		this.beneficiarios= new HashSet<>();
		this.tuvoAlgunAccidente=false;
	}
	
	

	public Boolean getTuvoAlgunAccidente() {
		return tuvoAlgunAccidente;
	}



	public void setTuvoAlgunAccidente(Boolean tuvoAlgunAccidente) {
		this.tuvoAlgunAccidente = tuvoAlgunAccidente;
	}



	public Set<Persona> getBeneficiarios() {
		return beneficiarios;
	}


	public void setBeneficiarios(Set<Persona> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}


	
	@Override
	public Integer obtenerCantidadBeneficiarios() {
		return this.beneficiarios.size();
	}

	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario tipo) {
		for (Persona persona2 : beneficiarios) {
			if(persona2.equals(persona)) {
				System.out.println("existe");
			}
		}this.beneficiarios.add(persona);
		
		
	}


	
	

}
