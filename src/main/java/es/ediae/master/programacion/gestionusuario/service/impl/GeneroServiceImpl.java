package es.ediae.master.programacion.gestionusuario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;

@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    private GeneroRepository generoRepository;
}
