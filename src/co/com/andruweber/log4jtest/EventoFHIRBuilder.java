package co.com.andruweber.log4jtest;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class EventoFHIRBuilder {
	private static final SimpleDateFormat FORMATO_FECHA_HORA_MILIS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	private static final String LABEL_TIPO_EVENTO = "tipo_evento";
	private static final String LABEL_FECHA_EVENTO = "fecha_evento";
	private static final String LABEL_ID_DOCUMENTO_C3 = "id_documento_c3";
	private static final String LABEL_ID_VISITA = "id_visita";
	private static final String LABEL_ID_TIPO_VISITA = "id_tipo_visita";
	private static final String LABEL_DESC_TIPO_VISITA = "desc_tipo_visita";
	private static final String LABEL_ID_ENCUENTRO = "id_encuentro";
	private static final String LABEL_ID_TIPO_ENCUENTRO = "id_tipo_encuentro";
	private static final String LABEL_DESC_TIPO_ENCUENTRO = "desc_tipo_encuentro";
	private static final String LABEL_TIPO_DOCUMENTO_PACIENTE = "tipo_documento_paciente";
	private static final String LABEL_DOCUMENTO_PACIENTE = "documento_paciente";
	private static final String LABEL_DETALLE_EVENTO = "detalle_evento";
	private static final String LABEL_TRAZA_EVENTO = "traza_evento";
	
	private static void addTipoEvento(JsonObject eventoFHIR, TipoEventoFHIR tipoEventoFHIR) {
		eventoFHIR.addProperty(LABEL_TIPO_EVENTO, tipoEventoFHIR.getDescripcionEvento());
	}
	
	private static void addFechaEvento(JsonObject eventoFHIR) {
		addFechaEvento(eventoFHIR, new Date());
	}
	
	private static void addFechaEvento(JsonObject eventoFHIR, Date fechaEvento) {
		eventoFHIR.addProperty(LABEL_FECHA_EVENTO, FORMATO_FECHA_HORA_MILIS.format(fechaEvento));
	}
	
	private static void addIdDocumentoC3(JsonObject eventoFHIR, String idDocumentoC3) {
		eventoFHIR.addProperty(LABEL_ID_DOCUMENTO_C3, idDocumentoC3);
	}
	
	private static void addIdVisita(JsonObject eventoFHIR, int idVisita) {
		eventoFHIR.addProperty(LABEL_ID_VISITA, idVisita);
	}
	
	private static void addIdTipoVisita(JsonObject eventoFHIR, int idTipoVisita) {
		eventoFHIR.addProperty(LABEL_ID_TIPO_VISITA, idTipoVisita);
	}
	
	private static void addDescTipoVisita(JsonObject eventoFHIR, String descTipoVisita) {
		eventoFHIR.addProperty(LABEL_DESC_TIPO_VISITA, descTipoVisita);
	}
	
	private static void addIdEncuentro(JsonObject eventoFHIR, int idEncuentro) {
		eventoFHIR.addProperty(LABEL_ID_ENCUENTRO, idEncuentro);
	}
	
	private static void addIdTipoEncuentro(JsonObject eventoFHIR, int idTipoEncuentro) {
		eventoFHIR.addProperty(LABEL_ID_TIPO_ENCUENTRO, idTipoEncuentro);
	}
	
	private static void addDescTipoEncuentro(JsonObject eventoFHIR, String descTipoEncuentro) {
		eventoFHIR.addProperty(LABEL_DESC_TIPO_ENCUENTRO, descTipoEncuentro);
	}
	
	private static void addTipoDocumentoPaciente(JsonObject eventoFHIR, String tipoDocumentoPaciente) {
		eventoFHIR.addProperty(LABEL_TIPO_DOCUMENTO_PACIENTE, tipoDocumentoPaciente);
	}
	
	private static void addDocumentoPaciente(JsonObject eventoFHIR, String documentoPaciente) {
		eventoFHIR.addProperty(LABEL_DOCUMENTO_PACIENTE, documentoPaciente);
	}
	
	private static void addDetalleEvento(JsonObject eventoFHIR, String detalleEvento) {
		eventoFHIR.addProperty(LABEL_DETALLE_EVENTO, detalleEvento);
	}
	
	private static void addTrazaEvento(JsonObject eventoFHIR, String trazaEvento) {
		eventoFHIR.addProperty(LABEL_TRAZA_EVENTO, trazaEvento);
	}
	
	private static String toString(JsonObject eventoFHIR) {
		Gson gson = new Gson();
		return gson.toJson(eventoFHIR);
	}
	
	public static String buildEventoConceptoNoHomologado(String idDocumentoC3, String tipoDocumentoPaciente, 
			String documentoPaciente, String detalleEvento) {
		JsonObject eventoFHIR = new JsonObject();
		
		addTipoEvento(eventoFHIR, TipoEventoFHIR.CONCEPTO_NO_HOMOLOGADO);
		addFechaEvento(eventoFHIR);
		addIdDocumentoC3(eventoFHIR, idDocumentoC3);
		addTipoDocumentoPaciente(eventoFHIR, tipoDocumentoPaciente);
		addDocumentoPaciente(eventoFHIR, documentoPaciente);
		addDetalleEvento(eventoFHIR, detalleEvento);
		
		return toString(eventoFHIR);
	}
	
	public static String buildEventoVisitaCreada(String idDocumentoC3, Visita visita, String tipoDocumentoPaciente, 
			String documentoPaciente, String detalleEvento) {
		JsonObject eventoFHIR = new JsonObject();
		
		addTipoEvento(eventoFHIR, TipoEventoFHIR.VISITA_CREADA);
		addFechaEvento(eventoFHIR, visita.getFechaVisita());
		addIdDocumentoC3(eventoFHIR, idDocumentoC3);
		addIdVisita(eventoFHIR, visita.getIdVisita());
		addIdTipoVisita(eventoFHIR, visita.getIdTipoVisita());
		addDescTipoVisita(eventoFHIR, visita.getDescTipoVisita());
		addTipoDocumentoPaciente(eventoFHIR, tipoDocumentoPaciente);
		addDocumentoPaciente(eventoFHIR, documentoPaciente);
		addDetalleEvento(eventoFHIR, detalleEvento);
		
		return toString(eventoFHIR);
	}
	
	public static String buildEventoEncuentroCreado(String idDocumentoC3, int idEncuentro, int idTipoEncuentro, 
			String descTipoEncuentro, Date fechaEncuentro, String tipoDocumentoPaciente, String documentoPaciente, 
			String detalleEvento) {
		JsonObject eventoFHIR = new JsonObject();
		
		addTipoEvento(eventoFHIR, TipoEventoFHIR.ENCUENTRO_CREADO);
		addFechaEvento(eventoFHIR, fechaEncuentro);
		addIdDocumentoC3(eventoFHIR, idDocumentoC3);
		addIdEncuentro(eventoFHIR, idEncuentro);
		addIdTipoEncuentro(eventoFHIR, idTipoEncuentro);
		addDescTipoEncuentro(eventoFHIR, descTipoEncuentro);
		addTipoDocumentoPaciente(eventoFHIR, tipoDocumentoPaciente);
		addDocumentoPaciente(eventoFHIR, documentoPaciente);
		addDetalleEvento(eventoFHIR, detalleEvento);
		
		return toString(eventoFHIR);
	}
	
	public static String buildEventoExcepcion(String idDocumentoC3, String tipoDocumentoPaciente, 
			String documentoPaciente, String detalleEvento, Throwable t) {
		JsonObject eventoFHIR = new JsonObject();
		
		addTipoEvento(eventoFHIR, TipoEventoFHIR.EXCEPCION);
		addFechaEvento(eventoFHIR);
		addIdDocumentoC3(eventoFHIR, idDocumentoC3);
		addTipoDocumentoPaciente(eventoFHIR, tipoDocumentoPaciente);
		addDocumentoPaciente(eventoFHIR, documentoPaciente);
		addDetalleEvento(eventoFHIR, detalleEvento);
		addTrazaEvento(eventoFHIR, LoggerHandler.getThrowableInformationAsString(t));
		
		return toString(eventoFHIR);
	}
}
