package co.com.portabilidad.acciones.persona;

import co.com.portabilidad.clases.Persona;

import java.math.BigInteger;
import java.util.List;

public interface ListaPersona {

    Persona listarPorNumeroCedulaYTipoDocumento(String tipoDocumento, BigInteger numeroCedula);

    List<Persona> listarTodos();

}
