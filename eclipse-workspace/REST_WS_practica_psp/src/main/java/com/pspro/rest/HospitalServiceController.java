package com.pspro.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pspro.rest.model.Hospital;
/**
 * Clase  encargada de procesar peticiones. Tiene recursos de nivel 1.
 * @author: Carlos Jiménez
 * @version: 01/03/2021/C
 *
 */
@RestController
public class HospitalServiceController {
	private static Map<String, Hospital> hospRepo = new HashMap<>();

	static {
		Hospital hosp1 = new Hospital();
		hosp1.setId("1");
		hosp1.setNombre("Macarena");
		hosp1.setnHabitaciones(300);
		
		hospRepo.put(hosp1.getId(), hosp1);
		
		Hospital hosp2 = new Hospital();
		hosp2.setId("2");
		hosp2.setNombre("Santa Catalina");
		hosp2.setnHabitaciones(130);
		
		hospRepo.put(hosp2.getId(), hosp2);
	}

	// Método que borra el hospital introducido:
	@DeleteMapping("/hospitales/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		if(hospRepo.get(id) != null) {
			hospRepo.remove(id);
			return new ResponseEntity<>("El Hospital se ha eliminado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("El Hospital indicado no existe", HttpStatus.OK);
		}
	}

	// Actualiza el hospital introducido con los diferentes campos deseados:
	@PutMapping("/hospitales/{id}")
	public ResponseEntity<Object> updateHospital(@PathVariable("id") String id, @RequestBody Hospital hosp) {
		if(hospRepo.get(id) != null) {
			hospRepo.remove(id);
			hosp.setId(id);
			hospRepo.put(id, hosp);
			return new ResponseEntity<>("El Hospital se ha actualizado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("El Hospital indicado no existe", HttpStatus.OK);
		}
	}
	
	// Crea el hospital introducido con los diferentes campos deseados:
	@PostMapping("/hospitales")
	public ResponseEntity<Object> createEspecialidad(@RequestBody Hospital hosp) {
		if (hosp.getId() != null && hospRepo.get(hosp.getId()) == null) {
			hospRepo.put(hosp.getId(), hosp);
			return new ResponseEntity<>("El Hospital se ha creado con éxito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("El Hospital no se pudo crear", HttpStatus.CREATED);
		}	
	}

	// Muestra todos los hospitales:
	@GetMapping("/hospitales")
	public ResponseEntity<Object> getHospitales() {
		return new ResponseEntity<>(hospRepo.values(), HttpStatus.OK);
	}
	
	// Muestra el hospital introducido:
	@GetMapping("/hospitales/{id}")
	public ResponseEntity<Object> getHospitalById(@PathVariable("id") String id) {
		if(hospRepo.get(id) != null) {
			return new ResponseEntity<>(hospRepo.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("El Hospital indicado no existe", HttpStatus.OK);
		}
	}

}