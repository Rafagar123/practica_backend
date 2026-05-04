package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.controller.DTO.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.service.impl.DireccionServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/direcciones")
public class DireccionController {
    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @GetMapping("/DirecPorUsuario/{usuarioId}")
    public List<DireccionDTO> buscarPorUsuarioId(@PathVariable Integer usuarioId) {
        return direccionServiceImpl.buscarPorUsuarioId(usuarioId).stream()
                .map(DireccionDTO :: fromModel)
                .toList();
    }

    @GetMapping("Direccion/{id}")
    public DireccionDTO buscarPorId(@PathVariable Integer id) {
        return DireccionDTO.fromModel(direccionServiceImpl.direccionPorId(id));
    }
}
