package com.pspro.webservice;
/**
 * Clase que nos permitirá consultar la información del Doctor. Actúa como una base de datos. 
 * Aquí sería el sitio donde engancharíamos JPA en un servicio web real.
 * @author: Carlos Jiménez
 * @version: 5/02/2021/C
 *
 */
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.pspro.xml.consulta.Doctor;
 
@Component
public class DoctorRepository {
    private static final Map<String, Doctor> doctores = new HashMap<>();
    
    // Funciona como si fueran consultas a la base de datos.
    @PostConstruct
    public void initData() {
        EspecialidadRepository eRepo = new EspecialidadRepository(); 
    	Doctor doctor = new Doctor();
        doctor.setFirstname("Antonio");
        doctor.setLastname("Amado");
        doctor.setEdad(54);
        doctor.setNColegiado("302269515");
        doctor.setEspecialidad(eRepo.getEspecialidades().get("Neurología"));
        
        doctores.put(doctor.getFirstname(), doctor);
         
        doctor = new Doctor();
        doctor.setFirstname("Luis");
        doctor.setLastname("Encinas");
        doctor.setEdad(45);
        doctor.setNColegiado("302269586");
        doctor.setEspecialidad(eRepo.getEspecialidades().get("Cardiología"));

        doctores.put(doctor.getFirstname(), doctor);
         
        doctor = new Doctor();
        doctor.setFirstname("Amaya");
        doctor.setLastname("Colmado");
        doctor.setEdad(40);
        doctor.setNColegiado("302269677");
        doctor.setEspecialidad(eRepo.getEspecialidades().get("Psiquiatría"));
        
        doctores.put(doctor.getFirstname(), doctor);
         
        doctor = new Doctor();
        doctor.setFirstname("Luis");
        doctor.setLastname("Hielo");
        doctor.setEdad(56);
        doctor.setNColegiado("302269769");
        doctor.setEspecialidad(eRepo.getEspecialidades().get("Traumatología"));
        
        doctores.put(doctor.getFirstname(), doctor);
    }
 
    public Doctor findDoctor(String name) {
        Assert.notNull(name, "El nombre del doctor no debe ser nulo");
        return doctores.get(name);
    }
  
    
}