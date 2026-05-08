package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.controller.DTO.GeneroDTO;
import es.ediae.master.programacion.gestionusuario.service.impl.GeneroServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/v1/generos")
public class GeneroController {

    @Autowired
    private GeneroServiceImpl generoServiceImpl;

    @GetMapping("/generos")
    public List<GeneroDTO> obtenerTodosGeneros(@RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return generoServiceImpl.obtenerTodosGeneros(nickUsuario, contrasena).stream()
                .map(GeneroDTO::fromModel)
                .toList();
    }
}
