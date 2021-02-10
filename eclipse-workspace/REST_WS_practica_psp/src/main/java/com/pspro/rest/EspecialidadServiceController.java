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

import com.pspro.rest.model.Doctor;
import com.pspro.rest.model.Especialidad;
/**
 * Clase  encargada de procesar peticiones. Consta de recursos de nivel 1 y 2. Clase que implementa la API REST y debe
 * contener la anotación @RestController para que Spring detecte que es el controlador y cualquier petición de tipo REST
 * que llegue será procesada por esta clase.
 * @author: Carlos Jiménez
 * @version: 10/02/2021/B
 *
 */
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

	private static Map<String, Doctor> doctorRepo = new HashMap<>();
	static {
		Doctor doc1 = new Doctor();
		doc1.setId("1");
		doc1.setName("Luis Encinas");
		doc1.setEdad(55);
		doc1.setDNI("30259928C");
		doc1.setEspecialidad(espRepo.get("1"));

		doctorRepo.put(doc1.getId(), doc1);

		Doctor doc2 = new Doctor();
		doc2.setId("2");
		doc2.setName("Antonio Rozas");
		doc2.setEdad(58);
		doc2.setDNI("30259979A");
		doc2.setEspecialidad(espRepo.get("2"));

		doctorRepo.put(doc2.getId(), doc2);

		Doctor doc3 = new Doctor();
		doc3.setId("3");
		doc3.setName("Amaya Espina");
		doc3.setEdad(60);
		doc3.setDNI("20259826D");
		doc3.setEspecialidad(espRepo.get("1"));

		doctorRepo.put(doc3.getId(), doc3);
	}

	//No se usa finalmente aquí
	public static Map<String, Especialidad> getMapEspecialidades() {
		return espRepo;
	}

	// ***** Operaciones CRUD de Especialidades (esp) *****
	
	@DeleteMapping("/esp/{idEsp}")
	public ResponseEntity<Object> delete(@PathVariable("idEsp") String id) {
		espRepo.remove(id);
		return new ResponseEntity<>("Doctor se ha eliminado con éxito", HttpStatus.OK);
	}

	@PutMapping("/esp/{idEsp}")
	public ResponseEntity<Object> updateEspecialidad(@PathVariable("idEsp") String id, @RequestBody Especialidad esp) {
		espRepo.remove(id);
		esp.setId(id);
		espRepo.put(id, esp);
		return new ResponseEntity<>("Doctor se ha actualizado con éxito", HttpStatus.OK);
	}

	@PostMapping("/esp")
	public ResponseEntity<Object> createEspecialidad(@RequestBody Especialidad esp) {
		espRepo.put(esp.getId(), esp);
		return new ResponseEntity<>("Doctor se ha creado con éxito", HttpStatus.CREATED);
	}

	@GetMapping("/esp")
	public ResponseEntity<Object> getEspecialidades() {
		return new ResponseEntity<>(espRepo.values(), HttpStatus.OK);
	}

	@GetMapping("/esp/{idEsp}")
	public ResponseEntity<Object> getEspecialidadById(@PathVariable("idEsp") String id) {
		return new ResponseEntity<>(espRepo.get(id), HttpStatus.OK);
	}

	
	// ***** Operaciones CRUD de Doctores *****
	
	
	@DeleteMapping("/esp/{idEsp}/doctores/{id}")
	public ResponseEntity<Object> deleteDoctor(@PathVariable("idEsp") String idEsp, @PathVariable("id") String id) {
		if (doctorRepo.get(id).getEspecialidad().getId().equals(idEsp)) {
			doctorRepo.remove(id);
			return new ResponseEntity<>("Doctor se ha eliminado con éxito", HttpStatus.OK);
		} else
			return new ResponseEntity<>("El Doctor no se ha eliminado porque no corresponde con esa especialidad",
					HttpStatus.OK);

	}

	@PutMapping("/esp/{idEsp}/doctores/{id}")
	public ResponseEntity<Object> updateDoctor(@PathVariable("idEsp") String idEsp, @PathVariable("id") String id,
			@RequestBody Doctor doctor) {
		if (doctorRepo.get(id).getEspecialidad().getId().equals(idEsp)) {
			doctorRepo.remove(id);
			doctor.setId(id);
			doctorRepo.put(id, doctor);
			return new ResponseEntity<>("Doctor se ha actualizado con éxito", HttpStatus.OK);
		} else
			return new ResponseEntity<>("El Doctor no se ha actualizado porque no ha sido encontrado en la especialidad indicada",
					HttpStatus.OK);
	}

	@PostMapping("/esp/{idEsp}/doctores")
	public ResponseEntity<Object> createDoctor(@PathVariable("idEsp") String idEsp, @RequestBody Doctor doctor) {
		doctor.setEspecialidad(espRepo.get(idEsp));
		doctorRepo.put(doctor.getId(), doctor);
		return new ResponseEntity<>("Doctor se ha creado con éxito", HttpStatus.CREATED);
	}

	
	@GetMapping("/esp/{idEsp}/doctores")
	public ResponseEntity<Object> getDoctores(@PathVariable("idEsp") String idEsp) {
		Map<String, Doctor> doctoresEsp = new HashMap<>();
		for (int id = 1; id <= doctorRepo.size(); id++) {
			if (doctorRepo.get(String.valueOf(id)).getEspecialidad().getId().equals(idEsp)) {
				doctoresEsp.put(String.valueOf(id), doctorRepo.get(String.valueOf(id)));
			}
		}
		return new ResponseEntity<>(doctoresEsp.values(), HttpStatus.OK);
	}
	
	@GetMapping("/esp/{idEsp}/doctores/{id}")
	public ResponseEntity<Object> getDoctorById(@PathVariable("idEsp") String idEsp, @PathVariable("id") String id) {
		if (doctorRepo.get(id).getEspecialidad().getId().equals(idEsp)) {
			return new ResponseEntity<>(doctorRepo.get(id), HttpStatus.OK);
		} else
			return new ResponseEntity<>("El Doctor no se puede mostrar porque no ha sido encontrado en la especialidad indicada",
					HttpStatus.CREATED);
	}


}