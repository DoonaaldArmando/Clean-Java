package co.com.portabilidad.implementacion;

import co.com.portabilidad.DAO.PersonaDAO;
import co.com.portabilidad.acciones.persona.GuardarPersona;
import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.convertidor.PersonaConvertidor;
import co.com.portabilidad.repositorio.PersonaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@AllArgsConstructor
public class CrearPersonaData implements GuardarPersona {

    private PersonaConvertidor personaConvertidor;
    private PersonaRepositorio personaRepositorio;


    @Override
    public Persona agregarPersona(Persona persona) {

        PersonaDAO personaAInsertar = personaConvertidor.personaAPersonaData(persona);

        PersonaDAO personaDAO = personaRepositorio.save(personaAInsertar);

        return personaConvertidor.personaDataAPersona(personaDAO);

    }
}
