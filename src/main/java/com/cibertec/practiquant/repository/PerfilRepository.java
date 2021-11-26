package com.cibertec.practiquant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.practiquant.entity.Perfil;


public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

	@Query("select p from Perfil p where "
			+ "( :p_nombre is '' or p.nombre like :p_nombre) and "
			+ "( :p_codperfil is 0 or p.codperfil = :p_codperfil) and"
			+ "( :p_apellido is '' or p.apellido = :p_apellido) ")
	public abstract List<Perfil> listaPerfil(
			@Param("p_nombre") String nombre,
			@Param("p_codperfil") int codperfil,
			@Param("p_apellido") String apellido);
	
	public List<Perfil> findByNombreLike(String nombre);
	public List<Perfil> findByNombre(String nombre);
}