package co.com.andruweber.log4jtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Log4jTestServlet
 */
public class Log4jTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log4jTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date fecha = new Date();
		
		LoggerHandler.fatal(LoggerHandler.FHIR_EVENTS_LOGGER, "-----------------" + fecha + "-----------------");
		LoggerHandler.trace(LoggerHandler.FHIR_EVENTS_LOGGER, "trace example");
		LoggerHandler.debug(LoggerHandler.FHIR_EVENTS_LOGGER, "debug example");	
		LoggerHandler.info(LoggerHandler.FHIR_EVENTS_LOGGER, "info example");
		LoggerHandler.warn(LoggerHandler.FHIR_EVENTS_LOGGER, "warn example");
		LoggerHandler.error(LoggerHandler.FHIR_EVENTS_LOGGER, "error example");
		LoggerHandler.fatal(LoggerHandler.FHIR_EVENTS_LOGGER, "fatal example");
		
		LoggerHandler.fatal(LoggerHandler.FHIR_EVENTS_LOGGER, "----------------------------------");
		LoggerHandler.info(LoggerHandler.LOG4J_TEST_SERVLET_LOGGER, "Prueba de log no guardado por el nivel heredado de la raiz");
		LoggerHandler.warn(LoggerHandler.LOG4J_TEST_SERVLET_LOGGER, "Prueba de log basado en el nombre de una clase");
		
		LoggerHandler.fatal(LoggerHandler.FHIR_EVENTS_LOGGER, "----------------------------------");
		String evento;
		String idDocumentoC3 = "59e19715-c945-49eb-b995-04507f56128d";
		int idVisita = 1152;
		int idTipoVisita = 12;
		String descTipoVisita = "Vista proveedor adscrito";
		int idEncuentro = 2658;
		int idTipoEncuentro = 30;
		String descTipoEncuentro = "Summary of episode note";
		String tipoDocumentoPaciente = "CC";
		String documentoPaciente = "12348968";
		String detalleEvento;
		
		detalleEvento = "No se encuentra homologación a un concepto de PHC para el concepto recibido [2344-1] del sistema [http://loinc.org].";
		evento = EventoFHIRBuilder.buildEventoConceptoNoHomologado(idDocumentoC3, tipoDocumentoPaciente, documentoPaciente, detalleEvento);
		LoggerHandler.warn(LoggerHandler.FHIR_EVENTS_LOGGER, evento);
		
		Visita visita = new Visita();
		visita.setIdVisita(idVisita);
		visita.setIdTipoVisita(idTipoVisita);
		visita.setDescTipoVisita(descTipoVisita);
		visita.setFechaVisita(fecha);
		detalleEvento = "Visita creada.";
		evento = EventoFHIRBuilder.buildEventoVisitaCreada(idDocumentoC3, visita, tipoDocumentoPaciente, documentoPaciente, detalleEvento);
		LoggerHandler.warn(LoggerHandler.FHIR_EVENTS_LOGGER, evento);
		
		Date fechaEncuentro = fecha;
		detalleEvento = "Encuentro creado.";
		evento = EventoFHIRBuilder.buildEventoEncuentroCreado(idDocumentoC3, idEncuentro, idTipoEncuentro, descTipoEncuentro, fechaEncuentro, tipoDocumentoPaciente, documentoPaciente, detalleEvento);
		LoggerHandler.warn(LoggerHandler.FHIR_EVENTS_LOGGER, evento);
		
		try {
			throw new Exception("Excepción de prueba.");
		} catch(Exception e) {
			detalleEvento = "Ocurrio una excepción al ejecutar las pruebas de Log4j.";
			evento = EventoFHIRBuilder.buildEventoExcepcion(idDocumentoC3, tipoDocumentoPaciente, documentoPaciente, detalleEvento, e);
			LoggerHandler.warn(LoggerHandler.FHIR_EVENTS_LOGGER, evento);
		}
		
		PrintWriter out = response.getWriter();
		out.print("<html><body><h1 align='center'>Log registrado: " + fecha + "</h1></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
