package co.com.portabilidad.implementacion.persona;

import co.com.portabilidad.acciones.persona.ExistenciaPersona;
import co.com.portabilidad.acciones.persona.GuardarPersona;
import co.com.portabilidad.clases.Persona;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
public class CrearPersonaData implements GuardarPersona, ExistenciaPersona {

    @Override
    public Persona agregarPersona(Persona persona) {
        return null;
    }

    @Override
    public Boolean existenciaPersona(String tipoDocumento, BigInteger numeroCedula) {
        return Boolean.FALSE;
    }
}
