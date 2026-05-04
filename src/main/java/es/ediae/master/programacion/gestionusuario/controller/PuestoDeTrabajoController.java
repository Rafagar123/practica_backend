package es.ediae.master.programacion.gestionusuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.service.impl.PuestoDeTrabajoServiceImpl;

@RestController
@RequestMapping("api/v1/puestosTrabajo")
public class PuestoDeTrabajoController {

    @Autowired
    private PuestoDeTrabajoServiceImpl puestoDeTrabajoServiceImpl;

}
