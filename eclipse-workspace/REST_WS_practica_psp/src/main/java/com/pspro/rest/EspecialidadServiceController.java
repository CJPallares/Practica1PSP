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

import com.pspro.rest.model.Especialidad;


@RestController
public class EspecialidadServiceController {
	private static Map<String, Especialidad> espRepo = new HashMap<>();

	static {
		Especialidad esp1 = new Especialidad();
		esp1.setId("1");
		esp1.setNombreEsp("Cirujano");
		esp1.setNConsulta(114);
		espRepo.put(esp1.getId(), esp1);

		Especialidad esp2 = new Especialidad();
		esp2.setId("2");
		esp2.setNombreEsp("Anestesista");
		esp2.setNConsulta(225);
		espRepo.put(esp2.getId(), esp2);
	}

	public static Map<String, Especialidad> getMapEspecialidades() {
		return espRepo;
	}

	@DeleteMapping("/doctores/esp/{idEsp}")
	public ResponseEntity<Object> delete(@PathVariable("idEsp") String id) {
		espRepo.remove(id);
		return new ResponseEntity<>("Especialidad se ha eliminado con éxito", HttpStatus.OK);
	}

	@PutMapping("/doctores/esp/{idEsp}")
	public ResponseEntity<Object> updateEspecialidad(@PathVariable("idEsp") String id, @RequestBody Especialidad esp) {
		espRepo.remove(id);
		esp.setId(id);
		espRepo.put(id, esp);
		return new ResponseEntity<>("Especialidad se ha actualizado con éxito", HttpStatus.OK);
	}

	@PostMapping("/doctores/esp")
	public ResponseEntity<Object> createEspecialidad(@RequestBody Especialidad esp) {
		espRepo.put(esp.getId(), esp);
		return new ResponseEntity<>("Especialidad se ha creado con éxito", HttpStatus.CREATED);
	}
	
	@GetMapping("/doctores/esp")
	public ResponseEntity<Object> getEspecialidades() {
		return new ResponseEntity<>(espRepo.values(), HttpStatus.OK);
	}

	@GetMapping("/doctores/esp/{idEsp}")
	public ResponseEntity<Object> getEspecialidadById(@PathVariable("idEsp") String id) {
		return new ResponseEntity<>(espRepo.get(id), HttpStatus.OK);
	}

	
}