package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.repository.PuestoDeTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.service.IPuestoDeTrabajo;
import es.ediae.master.programacion.gestionusuario.service.models.PuestoDeTrabajoModel;

@Service
public class PuestoDeTrabajoServiceImpl implements IPuestoDeTrabajo {

    @Autowired
    private PuestoDeTrabajoRepository puestoDeTrabajoRepository;

    @Override
    public List<PuestoDeTrabajoModel> obtenerTodosPuestos() {
        return puestoDeTrabajoRepository.findAll().stream()
                .map(PuestoDeTrabajoModel::fromEntity)
                .toList();
    }
}
