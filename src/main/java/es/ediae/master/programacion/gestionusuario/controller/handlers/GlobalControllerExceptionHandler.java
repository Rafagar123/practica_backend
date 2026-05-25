package es.ediae.master.programacion.gestionusuario.controller.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.ediae.master.programacion.gestionusuario.exception.GeneralException;

/**
 * Manejador Global de Excepciones
 * 
 * Esta clase intercepta y gestiona las excepciones lanzadas en toda la aplicación,
 * devolviendo respuestas HTTP consistentes en lugar de errores técnicos.
 * 
 * @RestControllerAdvice: Anotación que convierte esta clase en un manejador global
 *                        que intercepta excepciones de TODOS los controladores.
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * Manejador para excepciones de operaciones no soportadas
     * 
     * Se ejecuta cuando algún método lanza UnsupportedOperationException
     * (por ejemplo, cuando intentas usar un método no implementado en un repositorio)
     * 
     * @param ex: la excepción capturada
     * @return: el mensaje de error como String simple
     * 
     * @ResponseStatus(HttpStatus.NOT_IMPLEMENTED): Devuelve código HTTP 501
     *                                                (Operación no implementada)
     */
    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public String handleUnsupportedOperation(UnsupportedOperationException ex) {
        // Simplemente devolvemos el mensaje de la excepción al cliente
        return ex.getMessage();
    }

    /**
     * Manejador para las excepciones de negocio personalizadas
     * 
     * Se ejecuta cuando se lanza cualquier excepción que extienda GeneralException:
     *   - UsuarioNoValidoException
     *   - RepositoryMethodNotImplementedException
     *   - O cualquier otra excepción personalizada que crees
     * 
     * @param ex: la excepción capturada (contiene codigoDeError y mensajeDeError)
     * @return: un ModelMap (objeto que se convierte a JSON) con:
     *          - error: nombre de la clase de la excepción (ej: "UsuarioNoValidoException")
     *          - errorCode: código funcional de negocio (ej: 3)
     *          - errorMessage: mensaje amigable para el usuario (ej: "El usuario no es válido")
     * 
     * @ResponseStatus(HttpStatus.NOT_IMPLEMENTED): Devuelve código HTTP 501
     *                                                (Actualmente todas responden así)
     */
    @ExceptionHandler(GeneralException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ModelMap handleGeneralException(GeneralException ex) {
        // Construimos un objeto de respuesta estructurado
        ModelMap response = new ModelMap();
        
        // Nombre completo de la clase de la excepción
        // Ejemplo: "UsuarioNoValidoException"
        response.put("error", ex.getClass().getSimpleName());
        
        // Código de error de negocio (ej: 3, 11, etc.)
        response.put("errorCode", ex.getCodigoDeError());
        
        // Mensaje de error personalizado
        response.put("errorMessage", ex.getMensajeDeError());
        
        return response;
    }

}
