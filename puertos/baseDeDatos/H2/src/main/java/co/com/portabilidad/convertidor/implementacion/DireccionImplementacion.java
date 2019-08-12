package co.com.portabilidad.convertidor.implementacion;

import co.com.portabilidad.DAO.DireccionDAO;
import co.com.portabilidad.clases.Direccion;
import co.com.portabilidad.convertidor.DireccionConvertidor;
import co.com.portabilidad.validaciones.CadenaCaracter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DireccionImplementacion implements DireccionConvertidor {

    private final CadenaCaracter cadenaCaracter;

    @Override
    public Direccion direccionDataADireccion(DireccionDAO direccionData) {
        return Direccion
                .builder()
                .cadenaCaracter(cadenaCaracter)
                .ciudad(direccionData.getCiudad())
                .departamento(direccionData.getDepartamento())
                .ubicacion(direccionData.getUbicacion())
                .build();
    }

    @Override
    public DireccionDAO direccionADireccionData(Direccion direccion) {
        return DireccionDAO
                .builder()
                .ciudad(direccion.getCiudad())
                .departamento(direccion.getDepartamento())
                .ubicacion(direccion.getUbicacion())
                .build();
    }
}
