package com.pspro.webservice;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.pspro.xml.consulta.Especialidad;
 
@Component
public class EspecialidadRepository {
    private static final Map<String, Especialidad> especialidades = new HashMap<>();
 
    @PostConstruct
    public void initData() {
         
    	Especialidad especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("Traumatólogo");
        especialidad.setNombreHospital("Virgen del Rocío");
        especialidad.setNConsulta(01);
        especialidades.put(especialidad.getNombreEspecialidad(), especialidad);
                 
        especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("Cirujano");
        especialidad.setNombreHospital("Macarena");
        especialidad.setNConsulta(02);
        especialidades.put(especialidad.getNombreEspecialidad(), especialidad);
         
        especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("Psiquiatra");
        especialidad.setNombreHospital("San Lázaro");
        especialidad.setNConsulta(03);
        especialidades.put(especialidad.getNombreEspecialidad(), especialidad);
         
        especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("Neurólogo");
        especialidad.setNombreHospital("Santa Catalina");
        especialidad.setNConsulta(04);
        especialidades.put(especialidad.getNombreEspecialidad(), especialidad);
    }
 
    public Especialidad findEspecialidad(String name) {
        Assert.notNull(name, "The Especialidad's name must not be null");
        return especialidades.get(name);
    }
    
  //Método para conectar con DoctorRepository el Map
    public static Map<String, Especialidad> getEspecialidades() {
		return especialidades;
	}
}