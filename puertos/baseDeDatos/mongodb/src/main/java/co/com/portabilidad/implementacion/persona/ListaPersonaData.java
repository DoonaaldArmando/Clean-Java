package co.com.portabilidad.implementacion.persona;

import co.com.portabilidad.acciones.persona.ListaPersona;
import co.com.portabilidad.clases.Persona;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoActionOperation;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ListaPersonaData implements ListaPersona {

    private final MongoOperations mongoOperations;

    @Override
    public Persona listarPorNumeroCedulaYTipoDocumento(String tipoDocumento, BigInteger numeroCedula) {
        return null;
    }

    @Override
    public List<Persona> listarTodos() {
        return new ArrayList<>();
    }
}
