package co.com.portabilidad.acciones.persona;

import java.math.BigInteger;

public interface EliminarPersona {

    Void eliminar(String tipoDocumento, BigInteger numeroCedula);

}
