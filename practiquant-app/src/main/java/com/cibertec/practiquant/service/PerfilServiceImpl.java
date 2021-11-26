package com.cibertec.practiquant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.practiquant.entity.Perfil;
import com.cibertec.practiquant.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilRepository repository;
	
	@Override
	public Perfil insertaActualizaPerfil(Perfil obj) {
		return repository.save(obj);
	}

	@Override
	public List<Perfil> listarPorNombreLike(String nombre) {
		return repository.findByNombreLike(nombre);
	}

	@Override
	public List<Perfil> listaPorNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	
	@Override
	public List<Perfil> listaPerfil(String nombre, int codperfil, String apellido) {
		return repository.listaPerfil(nombre, codperfil, apellido);
	}

	@Override
	public List<Perfil> listaPerfil() {
		return repository.findAll();
	}

}
