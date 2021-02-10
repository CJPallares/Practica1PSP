package com.pspro.rest;
/**
 * Clase que implementa la API REST. La clase debe contener la anotación @RestController 
 * para que Spring detecte que es el controlador y cualquier petición de tipo REST
 * que llegue será procesada por esta clase.
 * @author: Carlos Jiménez
 * @version: 9/02/2021/B
 *
 */

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

@RestController
public class DoctorServiceController {
	// Simula nuestra base de datos, almacén de productos:
   private static Map<String, Doctor> doctorRepo = new HashMap<>();
   static {
      Doctor doc1 = new Doctor();
      doc1.setId("1");
      doc1.setName("Luis Encinas");
      doc1.setEdad(55);
      doc1.setDNI("30259928C");
	  doc1.setDepartamento(EspecialidadServiceController.getMapEspecialidades().get("Cirujano"));
	  
      doctorRepo.put(doc1.getId(), doc1);
      
      Doctor doc2 = new Doctor();
      doc2.setId("2");
      doc2.setName("Antonio Rozas");
      doc2.setEdad(55);
      doc2.setDNI("30259979A");
	  doc2.setDepartamento(EspecialidadServiceController.getMapEspecialidades().get("Anestesista"));

      doctorRepo.put(doc2.getId(), doc2);
      
      Doctor doc3 = new Doctor();
      doc3.setId("3");
      doc3.setName("Amaya Espina");
      doc3.setEdad(55);
      doc3.setDNI("20259826D");
	  doc3.setDepartamento(EspecialidadServiceController.getMapEspecialidades().get("Cirujano"));

      doctorRepo.put(doc3.getId(), doc3);
   }
   
   @DeleteMapping("/doctores/{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      doctorRepo.remove(id);
      return new ResponseEntity<>("Doctor se ha eliminado con éxito", HttpStatus.OK);
   }
   
   @PutMapping("/doctores/{id}")
   public ResponseEntity<Object> updateDoctor(@PathVariable("id") String id, @RequestBody Doctor doctor) { 
      doctorRepo.remove(id);
      doctor.setId(id);
      doctorRepo.put(id, doctor);
      return new ResponseEntity<>("Doctor se ha actualizado con éxito", HttpStatus.OK);
   }
  
   @PostMapping("/doctores")
   public ResponseEntity<Object> createDoctor(@RequestBody Doctor doctor) {
      doctorRepo.put(doctor.getId(), doctor);
      return new ResponseEntity<>("Doctor se ha creado con éxito", HttpStatus.CREATED);
   }
   
   @GetMapping("/doctores")
   public ResponseEntity<Object> getDoctores() {
      return new ResponseEntity<>(doctorRepo.values(), HttpStatus.OK);
   }
   
   @GetMapping("/doctores/{id}")
   public ResponseEntity<Object> getDoctorById(@PathVariable("id") String id) {
	      return new ResponseEntity<>(doctorRepo.get(id), HttpStatus.OK);
	   }
   
   
   
}