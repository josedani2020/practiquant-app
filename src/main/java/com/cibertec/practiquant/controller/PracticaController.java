package com.cibertec.practiquant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.practiquant.entity.Practica;
import com.cibertec.practiquant.service.PracticaService;
import com.cibertec.practiquant.utils.Constantes;

@RestController
@RequestMapping("/practiquant/practicas")
@CrossOrigin(origins = "http://localhost:4200")
public class PracticaController {
	
	@Autowired
	private PracticaService practicaService;
	
	@PostMapping("/registraPractica")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaPractica(@RequestBody Practica obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			if(obj.getEstado() == 0) {
				obj.setEstado(1);
			}
			Practica objSalida = practicaService.insertaActualizaPractica(obj);
			if(objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		}catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaPractica")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPractica(@RequestBody Practica obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			if(obj.getCodpractica() == 0) {
				salida.put("mensaje", "El ID del Perfil deb ser diferente de cera");
				return ResponseEntity.ok(salida);
			}
			Practica objSalida = practicaService.insertaActualizaPractica(obj);
			if(objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		}catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaPracticaPorDetalleLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Practica>> listarPracticaPorDetalleLike(@PathVariable("nom") String nom){
		System.out.println("nom");
		List<Practica> lista = null;
		try {
			if(nom.equals("todos")){
				lista = practicaService.listaPractica();
			}else {
				lista = practicaService.listaPorDetallepracticaLike("%" + nom + "%");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/listaPracticaActiva")
	@ResponseBody
	public ResponseEntity<List<Practica>> listaPracticaActiva(){
		List<Practica> listaPractica = practicaService.listaPracticaActiva();
		return ResponseEntity.ok(listaPractica);
	} 
}
