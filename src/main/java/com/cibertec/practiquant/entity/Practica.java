package com.cibertec.practiquant.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "practica")
public class Practica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codpractica;
	private String detallepractica;
	private String requisitopractica;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechatermino;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codperfil")
	private Perfil codperfil;
	private int estado;
	
	
	public int getCodpractica() {
		return codpractica;
	}
	public void setCodpractica(int codpractica) {
		this.codpractica = codpractica;
	}
	public String getDetallepractica() {
		return detallepractica;
	}
	public void setDetallepractica(String detallepractica) {
		this.detallepractica = detallepractica;
	}
	public String getRequisitopractica() {
		return requisitopractica;
	}
	public void setRequisitopractica(String requisitopractica) {
		this.requisitopractica = requisitopractica;
	}
	public Date getFechatermino() {
		return fechatermino;
	}
	public void setFechatermino(Date fechatermino) {
		this.fechatermino = fechatermino;
	}
	public Perfil getCodperfil() {
		return codperfil;
	}
	public void setCodperfil(Perfil codperfil) {
		this.codperfil = codperfil;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	

}