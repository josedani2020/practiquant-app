package com.cibertec.practiquant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.practiquant.entity.Postulacion;

public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {
	@Query("select p from Postulacion p where "
			+ "( :p_detallepostulante is '' or p.detallepostulante like :p_detallepostulante) and "
			+ "( :p_codpostulacion is 0 or p.codpostulacion = :p_codpostulacion) and"
			+ "( :p_estado is '' or p.estado = :p_estado) ")
	public abstract List<Postulacion> listaPostulacion(
			@Param("p_detallepostulante") String detallepostulante,
			@Param("p_codpostulacion") int codpostulacion,
			@Param("p_estado") String estado);
	
	

	


	public abstract List<Postulacion> findByDetallepostulanteLike(String detallepostulante);



	public abstract List<Postulacion> findByDetallepostulante(String detallepostulante);


	public abstract List<Postulacion> findByCodperfil(int codperfil);
	
}