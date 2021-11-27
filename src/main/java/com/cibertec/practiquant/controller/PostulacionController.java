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

import com.cibertec.practiquant.entity.Postulacion;
import com.cibertec.practiquant.service.PostulacionService;
import com.cibertec.practiquant.utils.Constantes;

@RestController
@RequestMapping("/practiquant/postulacion")
@CrossOrigin(origins = "http://localhost:4200")
public class PostulacionController {
	
	@Autowired
	private PostulacionService postulacionService;
	
	@PostMapping("/registroPostulacion")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaPostulacion(@RequestBody Postulacion obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			if(obj.getEstado() == 0) {
					obj.setEstado(1);
			}
			Postulacion objSalida = postulacionService.insertaActualizaPostulacion(obj);
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
	
	@PutMapping("/actualizaPostulacion")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPostulacion(@RequestBody Postulacion obj){
		
		
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getCodpostulacion() != 0) {
				Postulacion objSalida = postulacionService.insertaActualizaPostulacion(obj);
				if (objSalida == null) {
					salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
				} else {
					salida.put("mensaje", "Se actualizo correctamente");
				}	
			}else {
				salida.put("mensaje", "El ID del Proveedor debe ser diferente cero");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
		
		
		
	}
	
	@GetMapping("/listarPostulacionPorDetalleLike/{nom}")
	@ResponseBody
	public ResponseEntity<List<Postulacion>> listarPostulacionPorDetalleLike(@PathVariable("nom") String nom){
		System.out.println("nom");
		List<Postulacion> lista = null;
		try {
			if(nom.equals("todos")){
				lista = postulacionService.listaPostulacion();
			}else {
				lista = postulacionService.listaPorDetallepostulanteLike("%" + nom + "%");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	
	
	
	
	@GetMapping("/listaPostulacionActivo")
	@ResponseBody
	public ResponseEntity<List<Postulacion>> listaPostulacionActivo(){
		List<Postulacion> listaPostulacion = postulacionService.listaPostulacionActivo();
		return ResponseEntity.ok(listaPostulacion);
	} 
}
