package co.com.portabilidad.clases;


import co.com.portabilidad.excepciones.NumeroNegativo;
import co.com.portabilidad.excepciones.StringNoVacio;
import co.com.portabilidad.excepciones.ValorRequerido;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Numero;
import lombok.Builder;

import java.math.BigInteger;

public class Telefono {

    private static final String INDICATIVO_NULL = "El indicativo no puede ser nulo";
    private static final String INDICATIVO_VACIO = "El indicativo no puede ser vacio";
    private static final String NUMERO_NULL = "El numero no puede ser nulo";
    private static final String NUMERO_NEGATIVO = "El numero no puede ser negativo o cero";
    private static final String OBLIGATORIO_GENERICO = "Se deben suministrar las instancias de todos los validadores";

    private final String indicativo;
    private final BigInteger numero;


    private Telefono(
            String indicativo,
            BigInteger numero,
            CadenaCaracter cadenaCaracter,
            Numero validadorNumero
    ) {
        try {

            if (cadenaCaracter.cadenaNoVacia(indicativo)) {
                throw new StringNoVacio(INDICATIVO_VACIO);
            }

            if (cadenaCaracter.cadenaNoNula(indicativo)) {
                throw new ValorRequerido(INDICATIVO_NULL);
            }

            if (validadorNumero.numeroNoNegativo(numero)) {
                throw new NumeroNegativo(NUMERO_NEGATIVO);
            }

            if (validadorNumero.numeroNoNulo(numero)) {
                throw new ValorRequerido(NUMERO_NULL);
            }


        } catch (Exception e) {
            throw new ValorRequerido(OBLIGATORIO_GENERICO);
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
