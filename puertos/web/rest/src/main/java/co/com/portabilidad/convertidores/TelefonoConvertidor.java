package co.com.portabilidad.convertidores;

import co.com.portabilidad.DTO.TelefonoDTO;
import co.com.portabilidad.clases.Telefono;

public interface TelefonoConvertidor {

    Telefono telefonoDtoATelefono(TelefonoDTO telefonoDTO);

}
