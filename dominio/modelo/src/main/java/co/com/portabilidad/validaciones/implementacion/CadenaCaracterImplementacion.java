package co.com.portabilidad.validaciones.implementacion;

import co.com.portabilidad.validaciones.CadenaCaracter;

import java.util.Objects;

public final class CadenaCaracterImplementacion implements CadenaCaracter {

    @Override
    public Boolean cadenaNoVacia(String cadena) {

        if (cadena.isEmpty()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean cadenaNoNula(String cadena) {

        if (Objects.isNull(cadena)) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
