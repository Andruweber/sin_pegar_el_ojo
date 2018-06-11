package co.com.andruweber.log4jtest;

public class TipoEventoFHIR {
	public static final TipoEventoFHIR CONCEPTO_NO_HOMOLOGADO = new TipoEventoFHIR("EV_FHIR_CONCEPTO_NO_HOMOLOGADO");
	public static final TipoEventoFHIR VISITA_CREADA = new TipoEventoFHIR("EV_FHIR_VISITA_CREADA");
	public static final TipoEventoFHIR ENCUENTRO_CREADO = new TipoEventoFHIR("EV_FHIR_ENCUENTRO_CREADO");
	public static final TipoEventoFHIR EXCEPCION = new TipoEventoFHIR("EV_FHIR_EXCEPCION");
	
	private String descripcionEvento;
	
	protected TipoEventoFHIR(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}
	
	public String getDescripcionEvento() {
		return descripcionEvento;
	}
}
