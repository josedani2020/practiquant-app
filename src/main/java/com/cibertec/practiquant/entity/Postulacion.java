package com.cibertec.practiquant.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "postulacion")
public class Postulacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codpostulacion;
	private String detallepostulante;
	
	@JsonFormat(pattern = "yyyy-MM-dd" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechapostulacion;
	
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne
	@JoinColumn(name = "codpractica")
	private Practica codpractica;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne
	@JoinColumn(name = "codperfil")
	private Perfil codperfil;
	private int estado;

	
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getCodpostulacion() {
		return codpostulacion;
	}
	public void setCodpostulacion(int codpostulacion) {
		this.codpostulacion = codpostulacion;
	}
	public String getDetallepostulante() {
		return detallepostulante;
	}
	public void setDetallepostulante(String detallepostulante) {
		this.detallepostulante = detallepostulante;
	}
	public Date getFechapostulacion() {
		return fechapostulacion;
	}
	public void setFechapostulacion(Date fechapostulacion) {
		this.fechapostulacion = fechapostulacion;
	}
	public Practica getCodpractica() {
		return codpractica;
	}
	public void setCodpractica(Practica codpractica) {
		this.codpractica = codpractica;
	}
	public Perfil getCodperfil() {
		return codperfil;
	}
	public void setCodperfil(Perfil codperfil) {
		this.codperfil = codperfil;
	}
	

}