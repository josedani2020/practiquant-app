package com.cibertec.practiquant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.practiquant.entity.Postulacion;
import com.cibertec.practiquant.repository.PostulacionRepository;

@Service
public class PostulacionServiceImpl implements PostulacionService{

	@Autowired
	private PostulacionRepository repository;
	
	@Override
	public Postulacion insertaActualizaPostulacion(Postulacion obj) {
		return repository.save(obj);
	}

	@Override
	public List<Postulacion> listaPorDetallepostulanteLike(String detallepostulante) {
		return repository.findByDetallepostulanteLike(detallepostulante);
	}

	
	@Override
	public List<Postulacion> lsitaPorDetallepostulante(String detallepostulante) {
		return repository.findByDetallepostulante(detallepostulante);
	}

	@Override
	public List<Postulacion> listaPostulacion(String descripcion, int codpostulacion, String estado) {
		return repository.listaPostulacion(descripcion, codpostulacion, estado);
	}

	@Override
	public List<Postulacion> listaPostulacionporPefil(int codperfil) {
		return repository.findByCodperfil(codperfil);
	}

	@Override
	public List<Postulacion> listaPostulacion() {
		return repository.findAll();
	}

	
	
	
	@Override
	public List<Postulacion> listaPostulacionActivo() {
		// TODO Auto-generated method stub
		return repository.listaPostulacionActivo();
	}
	
	
	

}
