package com.cibertec.practiquant.service;

import java.util.List;

import com.cibertec.practiquant.entity.Perfil;

public interface PerfilService {
	public abstract List<Perfil> listaPerfil();
	public abstract Perfil insertaActualizaPerfil(Perfil obj);
	public abstract List<Perfil> listarPorNombreLike(String nombre);
	public abstract List<Perfil> listaPorNombre(String nombre);
	public abstract List<Perfil> listaPerfil(String nombre, int codperfil, String apellido);
}
