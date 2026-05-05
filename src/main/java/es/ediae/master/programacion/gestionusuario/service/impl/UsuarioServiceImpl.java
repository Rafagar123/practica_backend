package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioService;
import es.ediae.master.programacion.gestionusuario.service.models.UsuarioModel;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioModel> obtenerTodosUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioModel::fromEntity)
                .toList();
    }

    @Override
    public UsuarioModel usuarioPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(UsuarioModel::fromEntity)
                .orElse(null);
    }

    @Override
    public boolean eliminarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
