package co.com.portabilidad.excepciones;


import co.com.portabilidad.excepciones.modelo.InformacionError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class manejadorExcepciones {

    @ExceptionHandler({ListadoExceptiones.class, ExistenciaPrevia.class})
    public ResponseEntity<InformacionError> excepcionObligatorio(RuntimeException runtimeException) {
        return this.excepcionGenerica(
                runtimeException.getMessage()
        );
    }

    private ResponseEntity<InformacionError> excepcionGenerica(String mensajeError) {
        return ResponseEntity
                .badRequest()
                .body(
                        InformacionError
                                .builder()
                                .codigoError(HttpStatus.BAD_REQUEST.value())
                                .mensajeError(mensajeError)
                                .tipoError(HttpStatus.BAD_REQUEST)
                                .build()
                );
    }

}
