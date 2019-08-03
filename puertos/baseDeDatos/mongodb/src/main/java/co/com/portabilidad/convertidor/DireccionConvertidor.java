package co.com.portabilidad.convertidor;

import co.com.portabilidad.DAO.DireccionData;
import co.com.portabilidad.clases.Direccion;

public interface DireccionConvertidor {

    Direccion direccionDataADireccion(DireccionData direccionData);

    DireccionData direccionADireccionData(Direccion direccion);

}
