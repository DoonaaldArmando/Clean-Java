package co.com.portabilidad.implementacion.persona;

import co.com.portabilidad.acciones.persona.ExistenciaPersona;
import co.com.portabilidad.acciones.persona.GuardarPersona;
import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.convertidor.PersonaConvertidor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
@AllArgsConstructor
public class CrearPersonaData implements GuardarPersona {

    private final MongoOperations mongoOperations;
    private final PersonaConvertidor personaConvertidor;

    @Override
    public Persona agregarPersona(Persona persona) {
        return personaConvertidor
                .personaDataAPersona(
                        mongoOperations
                                .insert(
                                        personaConvertidor.personaAPersonaData(persona), Persona.class.getName()
                                )
                );

    }

}
