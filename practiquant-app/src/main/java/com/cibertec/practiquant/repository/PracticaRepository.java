package com.cibertec.practiquant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.practiquant.entity.Practica;

public interface PracticaRepository extends JpaRepository<Practica, Integer>{
	@Query("select p from Practica p where "
			+ "( :p_detallepractica is '' or p.detallepractica like :p_detallepractica) and "
			+ "( :p_codpractica is 0 or p.codpractica = :p_codpractica) and"
			+ "( :p_requisitopractica is '' or p.requisitopractica = :p_requisitopractica) ")
	public abstract List<Practica> listaPractica(
			@Param("p_detallepractica") String detallepractica,
			@Param("p_codpractica") int codpractica,
			@Param("p_requisitopractica") String requisitopractica);
	
	

	public abstract List<Practica> findByDetallepracticaLike(String detallepractica);



	public abstract List<Practica> findByDetallepractica(String detallepractica);
}