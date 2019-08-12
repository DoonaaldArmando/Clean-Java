package co.com.portabilidad.convertidor;

import co.com.portabilidad.DAO.DireccionDAO;
import co.com.portabilidad.clases.Direccion;

public interface DireccionConvertidor {

    Direccion direccionDataADireccion(DireccionDAO direccionData);

    DireccionDAO direccionADireccionData(Direccion direccion);

}
