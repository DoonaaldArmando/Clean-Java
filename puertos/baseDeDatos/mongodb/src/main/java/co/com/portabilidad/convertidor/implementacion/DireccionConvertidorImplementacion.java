package co.com.portabilidad.convertidor.implementacion;

import co.com.portabilidad.DAO.DireccionData;
import co.com.portabilidad.clases.Direccion;
import co.com.portabilidad.convertidor.DireccionConvertidor;
import co.com.portabilidad.validaciones.CadenaCaracter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DireccionConvertidorImplementacion implements DireccionConvertidor {

    private final CadenaCaracter cadenaCaracter;

    @Override
    public Direccion direccionDataADireccion(DireccionData direccionData) {
        return Direccion
                .builder()
                .cadenaCaracter(cadenaCaracter)
                .ciudad(direccionData.getCiudad())
                .departamento(direccionData.getDepartamento())
                .ubicacion(direccionData.getUbicacion())
                .build();
    }

    @Override
    public DireccionData direccionADireccionData(Direccion direccion) {
        return DireccionData
                .builder()
                .ciudad(direccion.getCiudad())
                .departamento(direccion.getDepartamento())
                .ubicacion(direccion.getUbicacion())
                .build();
    }
}
