package es.ediae.master.programacion.gestionusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.ediae.master.programacion.gestionusuario.controller.DTO.PuestoDeTrabajoDTO;
import es.ediae.master.programacion.gestionusuario.service.impl.PuestoDeTrabajoServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS })
@RequestMapping("api/v1/puestosTrabajo")
public class PuestoDeTrabajoController {

        @Autowired
        private PuestoDeTrabajoServiceImpl puestoDeTrabajoServiceImpl;

        @GetMapping("/puestos")
        public List<PuestoDeTrabajoDTO> obtenerTodosPuestos(@RequestParam String nickUsuario,
                        @RequestParam String contrasena) {
                return puestoDeTrabajoServiceImpl.obtenerTodosPuestos(nickUsuario, contrasena).stream()
                                .map(PuestoDeTrabajoDTO::fromModel)
                                .toList();
        }

}
