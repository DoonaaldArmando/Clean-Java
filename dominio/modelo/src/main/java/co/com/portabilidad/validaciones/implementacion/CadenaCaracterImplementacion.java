package co.com.portabilidad.validaciones.implementacion;

import co.com.portabilidad.validaciones.CadenaCaracter;

import java.util.Objects;

public final class CadenaCaracterImplementacion implements CadenaCaracter {

    @Override
    public Boolean cadenaVacia(String cadena) {

        if(!this.cadenaNula(cadena)){
            return Boolean.TRUE;
        }

        if (cadena.isEmpty()) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Boolean cadenaNula(String cadena) {

        if (Objects.isNull(cadena)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
