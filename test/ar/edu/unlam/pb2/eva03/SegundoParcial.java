package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

public class SegundoParcial {

	@Test
	public void queSePuedaEmitirUnaPolizaDeAutos() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;
		
		Persona asegurado = new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HIJA);
		Bien auto = new Auto("Ford", "Fiesta", 2010, SUMA_ASEGURADA);
		Poliza poliza = new PolizaDeAuto(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA, PREMIO);
		((PolizaDeAuto) poliza).agregarBienAsegurado(auto);
	
		assertEquals(NUMERO_DE_POLIZA, ((PolizaDeAuto)poliza).getNumeroDePoliza());
		//assertEquals(auto, ((PolizaDeAuto) poliza).getAutos());
		assertEquals(asegurado, ((PolizaDeAuto) poliza).getAsegurado());
		assertEquals(PREMIO, ((PolizaDeAuto) poliza).getPremio());
	}
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeVida() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;
		
		Persona asegurado = new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HIJA);
		Persona hijo = new Persona("Arturo", 65456231, 2, TipoDeBeneficiario.HIJO);
		Persona conyuge = new Persona("Arturo", 65456241, 3, TipoDeBeneficiario.CONYUGE);
		
		Poliza poliza = new PolizaAccidentesPersonales(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA, PREMIO);
		((PolizaAccidentesPersonales) poliza).agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		((PolizaAccidentesPersonales) poliza).agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
	
		assertEquals((Integer)2, ((PolizaAccidentesPersonales) poliza).obtenerCantidadBeneficiarios());
		assertEquals(asegurado, ((PolizaAccidentesPersonales) poliza).getAsegurado());
		assertEquals(PREMIO, ((PolizaAccidentesPersonales) poliza).getPremio());
	}
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeCombinadoFamiliar() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 20000000.0, PRIMA = 50000.0, PREMIO = 60000.0;
		
		Bien casa = new Vivienda("Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires");
		Persona asegurado = new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HERMANA);
		Persona hijo = new Persona("Arturo", 65456231, 2, TipoDeBeneficiario.HIJO);
		Persona hija = new Persona("Maia", 65445231, 4, TipoDeBeneficiario.HIJA);
		Persona conyuge = new Persona("Arturo", 65456232, 4, TipoDeBeneficiario.CONYUGE);
		
		Poliza poliza = new PolizaCombinadoFamiliar(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA, PREMIO);
		((SegurosDeVida) poliza).agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		((SegurosDeVida) poliza).agregarBeneficiario(hija, TipoDeBeneficiario.HIJA);
		((SegurosDeVida) poliza).agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
		((SegurosGenerales) poliza).agregarBienAsegurado(casa);
	
		assertEquals((Integer)3, ((PolizaCombinadoFamiliar)poliza).obtenerCantidadBeneficiarios());
		assertEquals(asegurado, poliza.getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
	}
	
	@Test
	public void queSePuedanAdministrarDistintosTiposDePolizas() {
		
		
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
		libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HIJA), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24, TipoDeBeneficiario.HIJO), 1500000.0, 4000.0, 60000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24, TipoDeBeneficiario.CONYUGE), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24, TipoDeBeneficiario.HERMANA), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Victor", 652354, 24, TipoDeBeneficiario.HIJO), 2000000.0, 5000.0, 60000.0));
		
		assertEquals((Integer)5, libra.obtenerLaCantidadDePolizasEmitidas());
	}

	
	@Test
	public void queSePuedaDenunciarElRoboDeUnAuto() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HIJA), 2000000.0, 5000.0, 60000.0));
		
		libra.denunciarSiniestro(1);
		
		assertTrue(libra.getPoliza(1).fueRobado());
	}
	
   @Test
	    public void queSePuedaDenunciarUnSiniestroParaUnaPolizaDeVida() throws PolizaInexistente{
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaAccidentesPersonales(1, new Persona("Pedro", 455647345, 24, TipoDeBeneficiario.CONYUGE), 2000000.0, 5000.0, 60000.0));
		
		libra.denunciarSiniestro(1);
		
		assertTrue(libra.getPoliza(1).tuvoAlgunAccidente());
		
	}
		
	
	@Test (expected = PolizaInexistente.class)
	public void verificarQueNoSePuedaDenunciarUnSiniestroParaUnaPolizaQueNoExista() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
	
		libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HIJA), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24, TipoDeBeneficiario.HIJO), 1500000.0, 4000.0, 60000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24, TipoDeBeneficiario.CONYUGE), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24, TipoDeBeneficiario.HERMANA), 2000000.0, 5000.0, 60000.0));
		libra.denunciarSiniestro(5);

	}
	

}
