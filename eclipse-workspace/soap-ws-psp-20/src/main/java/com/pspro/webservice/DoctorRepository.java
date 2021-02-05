package com.pspro.webservice;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.pspro.xml.consulta.Doctor;
 
@Component
public class DoctorRepository {
    private static final Map<String, Doctor> doctores = new HashMap<>();
 
    @PostConstruct
    public void initData() {
         
    	Doctor doctor = new Doctor();
        doctor.setFirstname("Antonio");
        doctor.setLastname("Amado");
        doctor.setEdad(54);
        doctor.setDni("30226951A");
        doctor.setEspecialidad(EspecialidadRepository.getEspecialidades().get("Traumatólogo"));
        
        doctores.put(doctor.getFirstname(), doctor);
         
        doctor = new Doctor();
        doctor.setFirstname("Luis");
        doctor.setLastname("Encinas");
        doctor.setEdad(45);
        doctor.setDni("30226958B");
        doctor.setEspecialidad(EspecialidadRepository.getEspecialidades().get("Cirujano"));
 
        doctores.put(doctor.getFirstname(), doctor);
         
        doctor = new Doctor();
        doctor.setFirstname("Amaya");
        doctor.setLastname("Colmado");
        doctor.setEdad(40);
        doctor.setDni("30226967C");
        doctor.setEspecialidad(EspecialidadRepository.getEspecialidades().get("Psiquiatra"));
        
        doctores.put(doctor.getFirstname(), doctor);
         
        doctor = new Doctor();
        doctor.setFirstname("Margarita");
        doctor.setLastname("Hielo");
        doctor.setEdad(56);
        doctor.setDni("30226976D");
        doctor.setEspecialidad(EspecialidadRepository.getEspecialidades().get("Neurólogo"));
        
        doctores.put(doctor.getFirstname(), doctor);
    }
 
    public Doctor findDoctor(String name) {
        Assert.notNull(name, "The Doctor's name must not be null");
        return doctores.get(name);
    }
  
    
}