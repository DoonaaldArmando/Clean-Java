package co.com.portabilidad.acciones.persona.listar;

import co.com.portabilidad.clases.Persona;

import java.math.BigInteger;
import java.util.List;

public interface ListarPersona {

    List<Persona> listarTodos();

    Persona listarPorNumeroCedulaYTipoCedula(String tipoCedula, BigInteger numeroCedula);

}
