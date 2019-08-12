package co.com.portabilidad.convertidor;

import co.com.portabilidad.DAO.TelefonoDAO;
import co.com.portabilidad.clases.Telefono;

public interface TelefonoConvertidor {

    Telefono telefonoDataATelefono(TelefonoDAO telefonoData);

    TelefonoDAO telefonoATelefonoData(Telefono telefono);

}
