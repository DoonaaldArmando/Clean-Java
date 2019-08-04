package co.com.portabilidad.convertidores;

import co.com.portabilidad.DTO.DireccionDTO;
import co.com.portabilidad.clases.Direccion;

public interface DireccionConvertidor {

    Direccion direccionDtoADireccion(DireccionDTO direccionDTO);

}
