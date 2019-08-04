package co.com.portabilidad.implementacion.persona;

import co.com.portabilidad.DAO.PersonaData;
import co.com.portabilidad.acciones.persona.ExistenciaPersona;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigInteger;

@AllArgsConstructor
public class ExistenciaPersonaData implements ExistenciaPersona {

    private final MongoOperations mongoOperations;

    @Override
    public Boolean existenciaPersona(String tipoCedula, BigInteger numeroCedula) {
        Query query = Query
                .query(
                        Criteria
                                .where("tipoCedula")
                                .is(tipoCedula)
                                .and("numeroCedula")
                                .is(numeroCedula)
                );
        return mongoOperations.exists(query, PersonaData.class);
    }
}
