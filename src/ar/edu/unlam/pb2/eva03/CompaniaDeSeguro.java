package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;

public class CompaniaDeSeguro {
	private String nombre;
	private Set<Poliza> polizasEmitidas;
	public CompaniaDeSeguro(String nombre) {
		this.nombre=nombre;
		this.polizasEmitidas=new HashSet<>();
	}

	public Integer obtenerLaCantidadDePolizasEmitidas() {
		return this.polizasEmitidas.size();
	}


	public void agregarPoliza(Poliza poliza) {
		this.polizasEmitidas.add(poliza);
	}

	public void denunciarSiniestro(Integer numero) throws PolizaInexistente {
	if(getPoliza(numero) instanceof PolizaDeAuto) {
		((PolizaDeAuto) getPoliza(numero)).setFueRobado(true);
	}else if(getPoliza(numero) instanceof PolizaAccidentesPersonales){
		((PolizaAccidentesPersonales) getPoliza(numero)).setTuvoAlgunAccidente(true);
	}
		
	}

	public Poliza getPoliza(int numero) {
		for (Poliza poliza : polizasEmitidas) {
			if(poliza.numeroDePoliza.equals(numero)) {
				return poliza;
			}
		}
		return null;
	}

}
