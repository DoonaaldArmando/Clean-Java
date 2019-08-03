package co.com.portabilidad.implementacion.persona;

import co.com.portabilidad.DAO.PersonaData;
import co.com.portabilidad.acciones.persona.ListaPersona;
import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.convertidor.PersonaConvertidor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class ListaPersonaData implements ListaPersona {

    private final MongoOperations mongoOperations;
    private final PersonaConvertidor personaConvertidor;

    @Override
    public Persona listarPorNumeroCedulaYTipoDocumento(String tipoDocumento, BigInteger numeroCedula) {
        Query query = Query
                .query(
                        Criteria
                                .where("tipoDocumento")
                                .is(tipoDocumento)
                                .and("numeroCedula")
                                .is(numeroCedula)
                );
        return personaConvertidor
                .personaDataAPersona(
                        mongoOperations
                                .findOne(query, PersonaData.class)
                );
    }

    @Override
    public List<Persona> listarTodos() {
        return mongoOperations
                .findAll(PersonaData.class)
                .stream()
                .map(personaConvertidor::personaDataAPersona)
                .collect(Collectors.toList());
    }
}
