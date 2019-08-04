package co.com.portabilidad.validaciones.implementacion;

import co.com.portabilidad.validaciones.Lista;

import java.util.List;
import java.util.Objects;

public final class ListaImplementacion implements Lista {

    @Override
    public Boolean listaVacia(List lista) {

        if (this.listaNula(lista)) {
            return Boolean.TRUE;
        }

        if (lista.isEmpty()) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Boolean listaNula(List lista) {

        if (Objects.isNull(lista)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
