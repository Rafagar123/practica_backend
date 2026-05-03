package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.entity.DireccionEntity;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/direcciones")
public class DireccionController {
    @Autowired
    private DireccionRepository direccionRepository;

    private Logger logger = LoggerFactory.getLogger(DireccionController.class);

    @GetMapping("/d_por_usuario/{usuarioId}")
    public List<DireccionEntity> getDireccionesByUsuarioId(@PathVariable Integer usuarioId) {
        return direccionRepository.buscarPorUsuarioId(usuarioId);
    }
    
}
