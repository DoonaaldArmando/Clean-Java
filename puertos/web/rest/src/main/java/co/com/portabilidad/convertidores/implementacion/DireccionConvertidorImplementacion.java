package co.com.portabilidad.convertidores.implementacion;

import co.com.portabilidad.DTO.DireccionDTO;
import co.com.portabilidad.clases.Direccion;
import co.com.portabilidad.convertidores.DireccionConvertidor;
import co.com.portabilidad.validaciones.CadenaCaracter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class DireccionConvertidorImplementacion implements DireccionConvertidor {

    private final CadenaCaracter cadenaCaracter;

    @Override
    public Direccion direccionDtoADireccion(DireccionDTO direccionDTO) {
        return Direccion
                .builder()
                .ubicacion(direccionDTO.getUbicacion())
                .cadenaCaracter(cadenaCaracter)
                .departamento(direccionDTO.getDepartamento())
                .ciudad(direccionDTO.getCiudad())
                .build();
    }
}
