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
 * @version: 01/03/2021/C
 *
 */
@RestController
public class EspecialidadServiceController {
	private static Map<String, Especialidad> espRepo = new HashMap<>();
	private static Map<String, Doctor> doctorRepo = new HashMap<>();
	static {
		Doctor doc1 = new Doctor();
		doc1.setId("1");
		doc1.setName("Luis Encinas");
		doc1.setEdad(55);
		doc1.setDNI("30259928C");
		
		doctorRepo.put(doc1.getId(), doc1);

		Doctor doc2 = new Doctor();
		doc2.setId("2");
		doc2.setName("Antonio Rozas");
		doc2.setEdad(58);
		doc2.setDNI("30259979A");

		doctorRepo.put(doc2.getId(), doc2);

		Doctor doc3 = new Doctor();
		doc3.setId("3");
		doc3.setName("Amaya Espina");
		doc3.setEdad(60);
		doc3.setDNI("20259826D");

		doctorRepo.put(doc3.getId(), doc3);
	
		Especialidad esp1 = new Especialidad();
		esp1.setId("1");
		esp1.setNombreEsp("Cirujano");
		esp1.setNConsulta(111);
		esp1.getListaDoctores().put(doctorRepo.get("1").getId(), doctorRepo.get("1"));
		esp1.getListaDoctores().put(doctorRepo.get("3").getId(), doctorRepo.get("3"));
		
		espRepo.put(esp1.getId(), esp1);

		
		Especialidad esp2 = new Especialidad();
		esp2.setId("2");
		esp2.setNombreEsp("Anestesista");
		esp2.setNConsulta(222);
		esp2.getListaDoctores().put(doctorRepo.get("2").getId(),doctorRepo.get("2"));

		espRepo.put(esp2.getId(), esp2);
	}


	

	// ************** Operaciones CRUD de Especialidades(esp) | Recursos de nivel 1 **************
	
	// Método que borra la Especialidad introducida:
	@DeleteMapping("/esp/{idEsp}")
	public ResponseEntity<Object> delete(@PathVariable("idEsp") String id) {
		if(espRepo.get(id) != null) {
			espRepo.remove(id);
			return new ResponseEntity<>("La Especialidad se ha eliminado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("La Especialidad indicada no existe", HttpStatus.OK);
		}
	}
	
	// Actualiza la Especialidad introducida mediante su id de Especialidad con los diferentes campos deseados:
	@PutMapping("/esp/{idEsp}")
	public ResponseEntity<Object> updateEspecialidad(@PathVariable("idEsp") String id, @RequestBody Especialidad esp) {
		if(espRepo.get(id) != null) {
			HashMap <String, Doctor> doctores = espRepo.get(id).getListaDoctores();
			espRepo.remove(id);
			esp.setId(id);
			esp.setListaDoctores(doctores);
			espRepo.put(id, esp);
			return new ResponseEntity<>("La Especialidad se ha actualizado con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("La Especialidad indicada no existe", HttpStatus.OK);
		}	
	}

	// Crea la Especialidad introducida con los diferentes campos deseados:
	@PostMapping("/esp")
	public ResponseEntity<Object> createEspecialidad(@RequestBody Especialidad esp) {
		if (esp.getId() != null && espRepo.get(esp.getId()) == null) {
			espRepo.put(esp.getId(), esp);
			return new ResponseEntity<>("La Especialidad se ha creado con éxito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("La Especialidad no se pudo crear, puede que ya exista", HttpStatus.CREATED);
		}
	}
	
	// Muestra todas las especialidades:
	@GetMapping("/esp")
	public ResponseEntity<Object> getEspecialidades() {
		if (espRepo.isEmpty()) {
			return new ResponseEntity<>("No existe ninguna especialidad", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(espRepo.values(), HttpStatus.OK);
		}
		
	}

	// Muestra la especialidad introducida:
	@GetMapping("/esp/{idEsp}")
	public ResponseEntity<Object> getEspecialidadById(@PathVariable("idEsp") String id) {
		if (espRepo.get(id) != null) {
			return new ResponseEntity<>(espRepo.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("La Especialidad indicada no existe", HttpStatus.OK);
		}
	}

	
	// ************** Operaciones CRUD de Doctores | Recursos de nivel 2 **************
	
	// Borra a un doctor si este pertenece a la especialidad introducida:
	@DeleteMapping("/esp/{idEsp}/doctores/{id}")
	public ResponseEntity<Object> deleteDoctor(@PathVariable("idEsp") String idEsp, @PathVariable("id") String id) {
		if (espRepo.get(idEsp).getListaDoctores().containsKey(id) && doctorRepo.get(id) != null) {
			doctorRepo.remove(id);
			espRepo.get(idEsp).eliminaDoctor(id);
			return new ResponseEntity<>("El Doctor se ha eliminado con éxito", HttpStatus.OK);
		} else
			return new ResponseEntity<>("El Doctor no se ha eliminado porque no corresponde con esa especialidad", HttpStatus.OK);

	}

	// Actualiza a un doctor si este pertenece a la especialidad introducida:
	@PutMapping("/esp/{idEsp}/doctores/{id}")
	public ResponseEntity<Object> updateDoctor(@PathVariable("idEsp") String idEsp, @PathVariable("id") String id,
			@RequestBody Doctor doctor) {
		if (espRepo.get(idEsp).getListaDoctores().containsKey(id) && doctorRepo.get(id) != null && doctorRepo.containsKey(id)) {
			doctorRepo.remove(id);
			espRepo.get(idEsp).getListaDoctores().remove(id);
			doctor.setId(id);
			doctorRepo.put(id, doctor);
			espRepo.get(idEsp).getListaDoctores().put(id, doctor);
			return new ResponseEntity<>("El Doctor se ha actualizado con éxito", HttpStatus.OK);
		} else
			return new ResponseEntity<>("El Doctor no se ha actualizado porque no ha sido encontrado en la especialidad indicada o no existe en la base de datos",
					HttpStatus.OK);
	}

	// Crea a un doctor que va a pertenecer a la especialidad introducida:
	@PostMapping("/esp/{idEsp}/doctores")
	public ResponseEntity<Object> createDoctor(@PathVariable("idEsp") String idEsp, @RequestBody Doctor doctor) {
		if (doctor.getId() != null && doctorRepo.get(doctor.getId()) == null && espRepo.containsKey(idEsp)) {
			doctorRepo.put(doctor.getId(), doctor);
			espRepo.get(idEsp).addDoctor(doctor);
			return new ResponseEntity<>("El Doctor se ha creado con éxito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("El Doctor no pudo crearse ya que no existe la especialidad indicada", HttpStatus.CREATED);
		}
		
	}

	// Muestra a todos los doctores de la especialidad introducida:
	@GetMapping("/esp/{idEsp}/doctores")
	public ResponseEntity<Object> getDoctores(@PathVariable("idEsp") String idEsp) {
		if (!espRepo.containsKey(idEsp) || espRepo.get(idEsp).getListaDoctores().isEmpty()) {
			return new ResponseEntity<>("No existen doctores en esa Especialidad", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(espRepo.get(idEsp).getListaDoctores().values(), HttpStatus.OK);
		}
	}
	
	// Muestra al doctor indicado de la especialidad introducida:
	@GetMapping("/esp/{idEsp}/doctores/{id}")
	public ResponseEntity<Object> getDoctorById(@PathVariable("idEsp") String idEsp, @PathVariable("id") String id) {
		if (espRepo.get(idEsp).getListaDoctores().containsKey(id) && doctorRepo.get(id) != null) {
			return new ResponseEntity<>(doctorRepo.get(id), HttpStatus.OK);
		} else
			return new ResponseEntity<>("El Doctor no ha sido encontrado en la especialidad indicada o no existe",
					HttpStatus.CREATED);
	}


}