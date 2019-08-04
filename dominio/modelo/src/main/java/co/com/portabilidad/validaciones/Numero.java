package co.com.portabilidad.validaciones;

import java.math.BigInteger;

public interface Numero {

    Boolean numeroNegativo(BigInteger numero);

    Boolean numeroNulo(BigInteger numero);

}
