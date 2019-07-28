package co.com.portabilidad.clases;


import co.com.portabilidad.excepciones.ListadoExceptiones;
import co.com.portabilidad.excepciones.mensajes.MensajesTelefono;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Numero;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Telefono {

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
                listadoExcepciones.add(MensajesTelefono.INDICATIVO_VACIO);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoNula(indicativo)) {
                listadoExcepciones.add(MensajesTelefono.INDICATIVO_NULL);
                excepcionProducida = Boolean.TRUE;
            }

        } catch (Exception e) {
            listadoExcepciones.add(MensajesTelefono.CADENA_CARACTER_NULO);
            excepcionProducida = Boolean.TRUE;

        }

        try {
            if (validadorNumero.numeroNoNegativo(numero)) {
                listadoExcepciones.add(MensajesTelefono.NUMERO_NEGATIVO);
                excepcionProducida = Boolean.TRUE;
            }

            if (validadorNumero.numeroNoNulo(numero)) {
                listadoExcepciones.add(MensajesTelefono.NUMERO_NULL);
                excepcionProducida = Boolean.TRUE;
            }

        } catch (Exception e) {
            listadoExcepciones.add(MensajesTelefono.VALIDADOR_NUMERO_NULO);
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
