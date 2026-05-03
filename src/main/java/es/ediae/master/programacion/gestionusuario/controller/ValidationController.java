package es.ediae.master.programacion.gestionusuario.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/validacion")
@Validated
public class ValidationController {

  

    @PostMapping("/producto")
    public ResponseEntity<ProductoDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO) {
        // Aquí podrías agregar lógica para guardar el producto en la base de datos
        return ResponseEntity.ok(productoDTO);
    }

}
