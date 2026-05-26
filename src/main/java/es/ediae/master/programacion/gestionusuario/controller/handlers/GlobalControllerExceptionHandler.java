package es.ediae.master.programacion.gestionusuario.controller.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.ediae.master.programacion.gestionusuario.exception.GeneralException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public String handleUnsupportedOperation(UnsupportedOperationException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(GeneralException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ModelMap handleGeneralException(GeneralException ex) {
        ModelMap response = new ModelMap();

        response.put("error", ex.getClass().getSimpleName());

        response.put("errorCode", ex.getCodigoDeError());

        response.put("errorMessage", ex.getMensajeDeError());

        return response;
    }

}
