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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.practiquant.entity.Perfil;
import com.cibertec.practiquant.service.PerfilService;
import com.cibertec.practiquant.utils.Constantes;

@RestController
@RequestMapping("/practiquant/perfiles")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;
	
	@PostMapping("/registraPerfil")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaPerfil(@RequestBody Perfil obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			if(obj.getEstado() == 0) {
				obj.setEstado(1);
			}
			Perfil objSalida = perfilService.insertaActualizaPerfil(obj);
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
	
	@PostMapping("/actualizarPerfil")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPerfil(@RequestBody Perfil obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			if(obj.getEstado() == 0) {
				salida.put("mensaje", "El ID del Perfil deb ser diferente de cera");
				return ResponseEntity.ok(salida);
			}
			Perfil objSalida = perfilService.insertaActualizaPerfil(obj);
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
	
	@GetMapping("/listaPerfilPorNombreLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Perfil>> listaPerfilPorNombreLike(@PathVariable("nom") String nom){
		System.out.println("nom");
		List<Perfil> lista = null;
		try {
			if (nom.equals("todos")) {
				lista = perfilService.listaPerfil();
			}else {
				lista = perfilService.listarPorNombreLike("%" + nom + "%");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
}
