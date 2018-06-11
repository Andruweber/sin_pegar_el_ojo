package co.com.andruweber.log4jtest;

import java.util.Date;

public class Visita {
	private int idVisita;
	private int idTipoVisita;
	private String descTipoVisita;
	private Date fechaVisita;
	
	public Visita() {	
	}

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public int getIdTipoVisita() {
		return idTipoVisita;
	}

	public void setIdTipoVisita(int idTipoVisita) {
		this.idTipoVisita = idTipoVisita;
	}

	public String getDescTipoVisita() {
		return descTipoVisita;
	}

	public void setDescTipoVisita(String descTipoVisita) {
		this.descTipoVisita = descTipoVisita;
	}

	public Date getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Date fechaVisita) {
		this.fechaVisita = fechaVisita;
	}
}
