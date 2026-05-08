package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.ediae.master.programacion.gestionusuario.controller.DTO.DireccionDTO;
import es.ediae.master.programacion.gestionusuario.controller.PostDTO.DireccionPostDTO;
import es.ediae.master.programacion.gestionusuario.service.impl.DireccionServiceImpl;
import es.ediae.master.programacion.gestionusuario.service.models.DireccionModel;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/direcciones")
public class DireccionController {
    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @GetMapping("/direc-por-usuario/{usuarioId}")
    public List<DireccionDTO> buscarPorUsuarioId(@PathVariable Integer usuarioId, @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return direccionServiceImpl.buscarPorUsuarioId(usuarioId, nickUsuario, contrasena).stream()
                .map(DireccionDTO::fromModel)
                .toList();
    }

    @GetMapping("/direcciones")
    public List<DireccionDTO> obtenerTodasDirecciones(@RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return direccionServiceImpl.obtenerTodasDirecciones(nickUsuario, contrasena).stream()
                .map(DireccionDTO::fromModel)
                .toList();
    }

    @GetMapping("/direccion/{id}")
    public DireccionDTO buscarPorId(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return DireccionDTO.fromModel(direccionServiceImpl.direccionPorId(id, nickUsuario, contrasena));
    }

    @PutMapping("/direccion/{id}")
    public DireccionDTO actualizarDireccion(@PathVariable Integer id, @RequestBody DireccionDTO direccionDTO,
            @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return DireccionDTO
                .fromModel(direccionServiceImpl.actualizarDireccion(id, DireccionModel.fromDTO(direccionDTO),
                        nickUsuario, contrasena));
    }

    @PostMapping("/direccion/{userId}")
    public DireccionDTO crearDireccion(@PathVariable Integer userId, @RequestBody DireccionPostDTO direccionPostDTO,
            @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return DireccionDTO
                .fromModel(direccionServiceImpl.crearDireccion(userId, DireccionModel.fromPostDTO(direccionPostDTO),
                        nickUsuario, contrasena));
    }

    @DeleteMapping("/direccion/{id}")
    public boolean eliminarDireccion(@PathVariable Integer id, @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return direccionServiceImpl.eliminarDireccion(id, nickUsuario, contrasena);
    }
}
