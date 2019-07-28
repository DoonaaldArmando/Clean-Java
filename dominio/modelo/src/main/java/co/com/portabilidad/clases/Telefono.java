package co.com.portabilidad.clases;


import co.com.portabilidad.excepciones.ListadoExceptiones;
import co.com.portabilidad.excepciones.NumeroNegativo;
import co.com.portabilidad.excepciones.StringNoVacio;
import co.com.portabilidad.excepciones.ValorRequerido;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Numero;
import lombok.Builder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Telefono {

    private static final String INDICATIVO_NULL = "El indicativo no puede ser nulo";
    private static final String INDICATIVO_VACIO = "El indicativo no puede ser vacio";
    private static final String NUMERO_NULL = "El numero no puede ser nulo";
    private static final String NUMERO_NEGATIVO = "El numero no puede ser negativo o cero";
    private static final String CADENA_CARACTER_NULO = "La cadena caracter no puede ser nula";
    private static final String VALIDADOR_NUMERO_NULO = "El validador numero no puede ser nulo";

    private final String indicativo;
    private final BigInteger numero;


    private Telefono(
            String indicativo,
            BigInteger numero,
            CadenaCaracter cadenaCaracter,
            Numero validadorNumero
    ) {
        Boolean excepcionProducida = Boolean.FALSE;
        List<String> listadoExcepciones = new <String>ArrayList();

        try {
            if (cadenaCaracter.cadenaNoVacia(indicativo)) {
                listadoExcepciones.add(INDICATIVO_VACIO);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoNula(indicativo)) {
                listadoExcepciones.add(INDICATIVO_NULL);
                excepcionProducida = Boolean.TRUE;
            }

        } catch (Exception e) {
            listadoExcepciones.add(CADENA_CARACTER_NULO);
            excepcionProducida = Boolean.TRUE;

        }

        try {
            if (validadorNumero.numeroNoNegativo(numero)) {
                listadoExcepciones.add(NUMERO_NEGATIVO);
                excepcionProducida = Boolean.TRUE;
            }

            if (validadorNumero.numeroNoNulo(numero)) {
                listadoExcepciones.add(NUMERO_NULL);
                excepcionProducida = Boolean.TRUE;
            }

        } catch (Exception e) {
            listadoExcepciones.add(VALIDADOR_NUMERO_NULO);
            excepcionProducida = Boolean.TRUE;
        }

        if (excepcionProducida) {
            throw new ListadoExceptiones(listadoExcepciones);
        }

        this.indicativo = indicativo;
        this.numero = numero;
    }

    public static TelefonoBuilder builder() {
        return new TelefonoBuilder();
    }

    public static class TelefonoBuilder {

        private String indicativo;
        private BigInteger numero;
        private CadenaCaracter cadenaCaracter;
        private Numero validadorNumero;

        private TelefonoBuilder() {
        }

        public TelefonoBuilder numero(BigInteger numero) {
            this.numero = numero;
            return this;
        }

        public TelefonoBuilder indicativo(String indicativo) {
            this.indicativo = indicativo;
            return this;
        }

        public TelefonoBuilder cadenaCaracter(CadenaCaracter cadenaCaracter) {
            this.cadenaCaracter = cadenaCaracter;
            return this;
        }

        public TelefonoBuilder validadorNumero(Numero validadorNumero) {
            this.validadorNumero = validadorNumero;
            return this;
        }

        public Telefono build() {
            return new Telefono(
                    this.indicativo,
                    this.numero,
                    this.cadenaCaracter,
                    this.validadorNumero
            );
        }

    }

}
