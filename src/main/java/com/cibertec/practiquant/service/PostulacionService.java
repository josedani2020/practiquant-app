package com.cibertec.practiquant.service;

import java.util.List;

import com.cibertec.practiquant.entity.Postulacion;


public interface PostulacionService {
	public abstract List<Postulacion> listaPostulacion();
	public abstract Postulacion insertaActualizaPostulacion(Postulacion obj);
	public abstract List<Postulacion> listaPostulacion(String descripcion, int codpostulacion, String estado);
	
	
	public abstract List<Postulacion> listaPostulacionActivo();
	
	
	List<Postulacion> listaPorDetallepostulanteLike(String detallepostulante);
	List<Postulacion> lsitaPorDetallepostulante(String detallepostulante);
	public abstract List<Postulacion> listaPostulacionporPefil(int codperfil);
}
