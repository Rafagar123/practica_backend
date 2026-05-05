package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ediae.master.programacion.gestionusuario.controller.DTO.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/usuarios")
    public List<UsuarioDTO> obtenerTodosUsuarios(){
        return usuarioServiceImpl.obtenerTodosUsuarios().stream()
                .map(UsuarioDTO::fromModel)
                .toList();
    }

    @GetMapping("/usuario/{id}")
    public UsuarioDTO usuarioPorId (@PathVariable Integer id){
        return UsuarioDTO.fromModel(usuarioServiceImpl.usuarioPorId(id));
    }

}
