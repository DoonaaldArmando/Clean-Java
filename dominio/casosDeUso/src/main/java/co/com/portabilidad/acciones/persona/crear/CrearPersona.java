package co.com.portabilidad.acciones.persona.crear;

import co.com.portabilidad.clases.Direccion;
import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.clases.Telefono;

import java.math.BigInteger;
import java.util.List;

public interface CrearPersona {

    Persona crearPersona(
            String nombre,
            String apellido,
            BigInteger numeroCedula,
            String tipoCedula,
            List<Telefono> telefonos,
            List<Direccion> direcciones
    );

}
