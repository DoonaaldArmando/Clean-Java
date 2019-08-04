package co.com.portabilidad.validaciones.implementacion;

import co.com.portabilidad.validaciones.Numero;

import java.math.BigInteger;
import java.util.Objects;


public final class NumeroImplementacion implements Numero {

    @Override
    public Boolean numeroNegativo(BigInteger numero) {
        if (numero.signum() == -1 || numero.equals(BigInteger.ZERO)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean numeroNulo(BigInteger numero) {
        if (Objects.isNull(numero)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
