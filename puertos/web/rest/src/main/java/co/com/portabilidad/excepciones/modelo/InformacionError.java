package co.com.portabilidad.excepciones.modelo;

import lombok.*;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class InformacionError {

    private HttpStatus tipoError;
    private Integer codigoError;
    private String mensajeError;

}
