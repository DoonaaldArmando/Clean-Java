package co.com.portabilidad.fabricas;


import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.clases.Telefono;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Lista;
import co.com.portabilidad.validaciones.Numero;
import lombok.AllArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
public class PersonaFabrica {

    private final CadenaCaracter cadenaCaracter;
    private final Numero numero;
    private final Lista lista;

    public void a() {
    }

}
