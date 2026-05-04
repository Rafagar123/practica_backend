package es.ediae.master.programacion.gestionusuario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.service.IPuestoDeTrabajo;

@Service
public class PuestoDeTrabajoServiceImpl implements IPuestoDeTrabajo {
    
    @Autowired
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;
}
