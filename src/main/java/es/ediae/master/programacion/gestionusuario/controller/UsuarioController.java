package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.ediae.master.programacion.gestionusuario.controller.DTO.UsuarioDTO;
import es.ediae.master.programacion.gestionusuario.controller.PostDTO.UsuarioPostDTO;
import es.ediae.master.programacion.gestionusuario.service.impl.UsuarioServiceImpl;
import es.ediae.master.programacion.gestionusuario.service.models.UsuarioModel;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/usuarios")
    public List<UsuarioDTO> obtenerTodosUsuarios() {
        return usuarioServiceImpl.obtenerTodosUsuarios().stream()
                .map(UsuarioDTO::fromModel)
                .toList();
    }

    @GetMapping("/usuario/{id}")
    public UsuarioDTO usuarioPorId(@PathVariable Integer id) {
        return UsuarioDTO.fromModel(usuarioServiceImpl.usuarioPorId(id));
    }

    @DeleteMapping("/usuario/{id}")
    public boolean borrarUsuario(@PathVariable Integer id) {
        return usuarioServiceImpl.eliminarUsuario(id);
    }

    @PutMapping("/usuario/{id}")
    public UsuarioDTO actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        return UsuarioDTO.fromModel(usuarioServiceImpl.actualizarUsuario(id, UsuarioModel.fromDTO(usuarioDTO)));
    }

    @PostMapping("usuario")
    public UsuarioDTO crearUsuario(@RequestBody UsuarioPostDTO usuarioPostDTO) {
        return UsuarioDTO.fromModel(usuarioServiceImpl.crearUsuario(UsuarioModel.fromPostDTO(usuarioPostDTO)));
    }
    

}
