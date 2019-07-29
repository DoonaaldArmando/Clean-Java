package co.com.portabilidad.implementacion.persona;

import co.com.portabilidad.acciones.persona.ListarPersona;
import co.com.portabilidad.clases.Persona;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ListarPersonaData implements ListarPersona {

    @Override
    public Persona listarPorNumeroCedulaYTipoDocumento(String tipoDocumento, BigInteger numeroCedula) {
        return null;
    }

    @Override
    public List<Persona> listarTodos() {
        return null;
    }
}
