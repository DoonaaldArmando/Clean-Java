package co.com.portabilidad.acciones.persona.lista;


import co.com.portabilidad.acciones.persona.ListaPersona;
import co.com.portabilidad.clases.Persona;
import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
public class ListarPersonaImplementacion implements ListarPersona {

    private final ListaPersona listaPersona;

    @Override
    public List<Persona> listarTodos() {
        return listaPersona.listarTodos();
    }

    @Override
    public Persona listarPorNumeroCedulaYTipoCedula(String tipoCedula, BigInteger numeroCedula) {
        return listaPersona.listarPorNumeroCedulaYTipoDocumento(tipoCedula, numeroCedula);
    }
}

