package co.com.portabilidad.convertidor;

import co.com.portabilidad.DAO.PersonaDAO;
import co.com.portabilidad.clases.Persona;

public interface PersonaConvertidor {

    Persona personaDataAPersona(PersonaDAO personaData);

    PersonaDAO personaAPersonaData(Persona persona);

}
