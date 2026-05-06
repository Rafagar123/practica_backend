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
    public List<DireccionDTO> buscarPorUsuarioId(@PathVariable Integer usuarioId) {
        return direccionServiceImpl.buscarPorUsuarioId(usuarioId).stream()
                .map(DireccionDTO :: fromModel)
                .toList();
    }

    @GetMapping("/direcciones")
    public List<DireccionDTO> obtenerTodasDirecciones() {
        return direccionServiceImpl.obtenerTodasDirecciones().stream()
                .map(DireccionDTO :: fromModel)
                .toList();
    }

    @GetMapping("/direccion/{id}")
    public DireccionDTO buscarPorId(@PathVariable Integer id) {
        return DireccionDTO.fromModel(direccionServiceImpl.direccionPorId(id));
    }

    @PutMapping("/direccion/{id}")
    public DireccionDTO actualizarDireccion(@PathVariable Integer id, @RequestBody DireccionDTO direccionDTO) {
        return DireccionDTO.fromModel(direccionServiceImpl.actualizarDireccion(id, DireccionModel.fromDTO(direccionDTO)));
    }

    @PostMapping("/direccion/{userId}")
    public DireccionDTO crearDireccion(@PathVariable Integer userId, @RequestBody DireccionPostDTO direccionPostDTO){
        return DireccionDTO.fromModel(direccionServiceImpl.crearDireccion(userId, DireccionModel.fromPostDTO(direccionPostDTO)));
    }

    @DeleteMapping("/direccion/{id}")
    public boolean eliminarDireccion(@PathVariable Integer id) {
        return direccionServiceImpl.eliminarDireccion(id);
    }
}
