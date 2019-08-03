package co.com.portabilidad.convertidor;

import co.com.portabilidad.DAO.PersonaData;
import co.com.portabilidad.clases.Persona;

public interface PersonaConvertidor {

    Persona personaDataAPersona(PersonaData personaData);

    PersonaData personaAPersonaData(Persona persona);

}
