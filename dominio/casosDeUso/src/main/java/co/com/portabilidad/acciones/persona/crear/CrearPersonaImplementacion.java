package co.com.portabilidad.acciones.persona.crear;

import co.com.portabilidad.acciones.persona.ExistenciaPersona;
import co.com.portabilidad.acciones.persona.GuardarPersona;
import co.com.portabilidad.acciones.persona.crear.CrearPersona;
import co.com.portabilidad.clases.Direccion;
import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.clases.Telefono;
import co.com.portabilidad.excepciones.ExistenciaPrevia;
import co.com.portabilidad.fabricas.PersonaFabrica;
import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
public class CrearPersonaImplementacion implements CrearPersona {

    private static final String EXISTENCIA_PREVIA_PERSONA = "La persona que intenta insertar ya se encuentra guardada";


    private final PersonaFabrica personaFabrica;
    private final GuardarPersona guardarPersona;
    private final ExistenciaPersona existenciaPersona;

    @Override
    public Persona crearPersona(
            String nombre,
            String apellido,
            BigInteger numeroCedula,
            String tipoCedula,
            List<Telefono> telefonos,
            List<Direccion> direcciones
    ) {
        if (this.existenciaPersona.existenciaPersona(tipoCedula, numeroCedula)) {
            return this.crear(
                    nombre,
                    apellido,
                    numeroCedula,
                    tipoCedula,
                    telefonos,
                    direcciones);
        }

        throw new ExistenciaPrevia(EXISTENCIA_PREVIA_PERSONA);
    }

    private Persona crear(
            String nombre,
            String apellido,
            BigInteger numeroCedula,
            String tipoCedula,
            List<Telefono> telefonos,
            List<Direccion> direcciones
    ) {
        return this.guardarPersona.agregarPersona(
                this.personaFabrica.crearPersona(
                        nombre,
                        apellido,
                        numeroCedula,
                        tipoCedula,
                        telefonos,
                        direcciones)
        );
    }

}
