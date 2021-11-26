package com.cibertec.practiquant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.practiquant.entity.Practica;
import com.cibertec.practiquant.repository.PracticaRepository;
@Service
public class PracticaServiceImpl implements PracticaService{

	@Autowired
	private PracticaRepository repository;
	
	@Override
	public Practica insertaActualizaPractica(Practica obj) {
		return repository.save(obj);
	}

	@Override
	public List<Practica> listaPorDetallepracticaLike(String detallepractica) {
		return repository.findByDetallepracticaLike(detallepractica);
	}

	@Override
	public List<Practica> listaPorDetallepractica(String detallepractica) {
		return repository.findByDetallepractica(detallepractica);
	}

	@Override
	public List<Practica> listaPractica(String detallepractica, int codpractica, String requisitopractica) {
		return repository.listaPractica(detallepractica, codpractica, requisitopractica);
	}

	@Override
	public List<Practica> listaPractica() {
		return repository.findAll();
	}
}
