package co.com.portabilidad.validaciones.implementacion;

import co.com.portabilidad.validaciones.Lista;

import java.util.List;
import java.util.Objects;

public final class ListaImplementacion implements Lista {

    @Override
    public Boolean listaNoVacia(List lista) {

        if (lista.isEmpty()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean listaNoNula(List lista) {

        if (Objects.isNull(lista)) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
