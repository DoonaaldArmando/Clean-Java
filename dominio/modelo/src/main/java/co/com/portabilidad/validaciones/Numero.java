package co.com.portabilidad.validaciones;

import java.math.BigInteger;

public interface Numero {

    Boolean numeroNoNegativo(BigInteger numero);

    Boolean numeroNoNulo(BigInteger numero);

}
