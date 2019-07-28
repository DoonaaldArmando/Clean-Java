package co.com.portabilidad.validaciones.implementacion;

import co.com.portabilidad.validaciones.Numero;

import java.math.BigInteger;
import java.util.Objects;


public final class NumeroImplementacion implements Numero {

    @Override
    public Boolean numeroNoNegativo(BigInteger numero) {
        if (numero.signum() == -1 || numero.equals(BigInteger.ZERO)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean numeroNoNulo(BigInteger numero) {
        if (Objects.isNull(numero)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
