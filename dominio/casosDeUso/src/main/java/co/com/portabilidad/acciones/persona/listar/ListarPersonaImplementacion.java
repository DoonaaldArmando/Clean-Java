package co.com.portabilidad.acciones.persona.listar;


import co.com.portabilidad.clases.Persona;
import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
public class ListarPersonaImplementacion implements ListarPersona {

    private final co.com.portabilidad.acciones.persona.ListarPersona listarPersona;

    @Override
    public List<Persona> listarTodos() {
        return listarPersona.listarTodos();
    }

    @Override
    public Persona listarPorNumeroCedulaYTipoCedula(String tipoCedula, BigInteger numeroCedula) {
        return listarPersona.listarPorNumeroCedulaYTipoDocumento(tipoCedula, numeroCedula);
    }
}

