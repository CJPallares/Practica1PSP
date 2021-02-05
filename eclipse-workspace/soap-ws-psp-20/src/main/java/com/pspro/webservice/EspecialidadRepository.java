package com.pspro.webservice;
/**
 * Clase que nos permitirá consultar la información de la Especialidad. Actúa como una base de datos. 
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
import com.pspro.xml.consulta.Especialidad;
 
@Component
public class EspecialidadRepository {
    private static final Map<String, Especialidad> especialidades = new HashMap<>();
    // Funciona como si fueran consultas a la base de datos.
    @PostConstruct
    public void initData() { 
         
    	Especialidad especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("Traumatología");
        especialidad.setNombreHospital("Virgen del Rocío");
        especialidad.setNConsulta(01);
        especialidades.put(especialidad.getNombreEspecialidad(), especialidad);
                 
        especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("Cardiología");
        especialidad.setNombreHospital("Macarena");
        especialidad.setNConsulta(02);
        especialidades.put(especialidad.getNombreEspecialidad(), especialidad);
         
        especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("Psiquiatría");
        especialidad.setNombreHospital("San Lázaro");
        especialidad.setNConsulta(03);
        especialidades.put(especialidad.getNombreEspecialidad(), especialidad);
        
        especialidad = new Especialidad();
        especialidad.setNombreEspecialidad("Neurología");
        especialidad.setNombreHospital("Santa Catalina");
        especialidad.setNConsulta(04);
        especialidades.put(especialidad.getNombreEspecialidad(), especialidad);
    }
 
    public Especialidad findEspecialidad(String name) {
        Assert.notNull(name, "El nombre de Especialidad no debe ser nulo");
        return especialidades.get(name);
    }
    
    // Método para conectar con DoctorRepository el Map y conseguir visualizar la especialidad del doctor.
    public static Map<String, Especialidad> getEspecialidades() {
		return especialidades;
	}
}