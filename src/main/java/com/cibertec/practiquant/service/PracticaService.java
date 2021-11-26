package com.cibertec.practiquant.service;

import java.util.List;

import com.cibertec.practiquant.entity.Practica;

public interface PracticaService {
	public abstract List<Practica> listaPractica();
	public abstract Practica insertaActualizaPractica(Practica obj);
	public abstract List<Practica> listaPorDetallepracticaLike(String detallepractica);
	public abstract List<Practica> listaPorDetallepractica(String detallepractica);
	public abstract List<Practica> listaPractica(String detallepractica, int codpractica, String requisitopractica);
}
