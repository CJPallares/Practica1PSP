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
 * @version: 10/02/2021/B
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

	@DeleteMapping("/hospitales/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		hospRepo.remove(id);
		return new ResponseEntity<>("Hospital se ha eliminado con éxito", HttpStatus.OK);
	}

	@PutMapping("/hospitales/{id}")
	public ResponseEntity<Object> updateHospital(@PathVariable("id") String id, @RequestBody Hospital hosp) {
		hospRepo.remove(id);
		hosp.setId(id);
		hospRepo.put(id, hosp);
		return new ResponseEntity<>("Hospital se ha actualizado con éxito", HttpStatus.OK);
	}

	@PostMapping("/hospitales")
	public ResponseEntity<Object> createEspecialidad(@RequestBody Hospital hosp) {
		hospRepo.put(hosp.getId(), hosp);
		return new ResponseEntity<>("Hospital se ha creado con éxito", HttpStatus.CREATED);
	}

	@GetMapping("/hospitales")
	public ResponseEntity<Object> getHospitales() {
		return new ResponseEntity<>(hospRepo.values(), HttpStatus.OK);
	}

	@GetMapping("/hospitales/{id}")
	public ResponseEntity<Object> getHospitalById(@PathVariable("id") String id) {
		return new ResponseEntity<>(hospRepo.get(id), HttpStatus.OK);
	}

}