package co.com.portabilidad.clases;


import co.com.portabilidad.excepciones.ListadoExceptiones;
import co.com.portabilidad.excepciones.mensajes.MensajesTelefono;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Numero;
import lombok.Getter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Telefono {

    private final String indicativo;
    private final BigInteger numero;

    private Telefono(
            String indicativo,
            BigInteger numero,
            CadenaCaracter cadenaCaracter,
            Numero validadorNumero
    ) {
        List<String> listadoExcepciones = new <String>ArrayList();

        this.validarCadenasCaracteres(listadoExcepciones, cadenaCaracter,indicativo);
        this.validarNumeros(listadoExcepciones, validadorNumero,numero);

        if (!listadoExcepciones.isEmpty()) {
            throw new ListadoExceptiones(listadoExcepciones);
        }

        this.indicativo = indicativo;
        this.numero = numero;
    }

    private void validarCadenasCaracteres(
            List<String> listadoExcepciones,
            CadenaCaracter cadenaCaracter,
            String indicativo
    ) {
        try {
            if (cadenaCaracter.cadenaVacia(indicativo)) {
                listadoExcepciones.add(MensajesTelefono.INDICATIVO_VACIO);
            }

            if (cadenaCaracter.cadenaNula(indicativo)) {
                listadoExcepciones.add(MensajesTelefono.INDICATIVO_NULL);
            }

        } catch (Exception e) {
            listadoExcepciones.add(MensajesTelefono.CADENA_CARACTER_NULO);
        }
    }

    private void validarNumeros(
            List<String> listadoExcepciones,
            Numero validadorNumero,
            BigInteger numero
    ) {
        try {
            if (validadorNumero.numeroNegativo(numero)) {
                listadoExcepciones.add(MensajesTelefono.NUMERO_NEGATIVO);
            }

            if (validadorNumero.numeroNulo(numero)) {
                listadoExcepciones.add(MensajesTelefono.NUMERO_NULL);
            }

        } catch (Exception e) {
            listadoExcepciones.add(MensajesTelefono.VALIDADOR_NUMERO_NULO);
        }
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
