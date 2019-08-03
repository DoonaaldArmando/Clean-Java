package co.com.portabilidad.convertidor;

import co.com.portabilidad.DAO.TelefonoData;
import co.com.portabilidad.clases.Telefono;

public interface TelefonoConvertidor {

    Telefono telefonoDataATelefono(TelefonoData telefonoData);

    TelefonoData telefonoATelefonoData(Telefono telefono);

}
