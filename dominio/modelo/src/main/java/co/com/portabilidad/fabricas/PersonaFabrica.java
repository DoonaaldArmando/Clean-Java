package co.com.portabilidad.fabricas;


import co.com.portabilidad.clases.Direccion;
import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.clases.Telefono;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Lista;
import co.com.portabilidad.validaciones.Numero;
import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
public class PersonaFabrica {

    private final CadenaCaracter cadenaCaracter;
    private final Numero numero;
    private final Lista lista;

    public Persona crearPersona(
            String nombre,
            String apellido,
            BigInteger numeroCedula,
            String tipoCedula,
            List<Telefono> telefonos,
            List<Direccion> direcciones
    ) {
        return Persona
                .builder()
                .apellido(apellido)
                .cadenaCaracter(cadenaCaracter)
                .direcciones(direcciones)
                .nombre(nombre)
                .numeroCedula(numeroCedula)
                .telefonos(telefonos)
                .tipoCedula(tipoCedula)
                .validadorNumero(numero)
                .validadorLista(lista)
                .build();
    }

}
