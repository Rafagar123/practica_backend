package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.UsuarioEntity;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;
import es.ediae.master.programacion.gestionusuario.service.models.GeneroModel;

@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<GeneroModel> obtenerTodosGeneros(String nickUsuario, String contrasena) {

        UsuarioEntity usuario = usuarioRepository.findByNickUsuario(nickUsuario);

        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return generoRepository.findAll().stream()
                    .map(GeneroModel::fromEntity)
                    .toList();
        } else {
            return null;
        }

    }
}
