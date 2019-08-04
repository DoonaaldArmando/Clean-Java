package co.com.portabilidad.clases;

import co.com.portabilidad.excepciones.*;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.excepciones.mensajes.MensajesPersona;
import co.com.portabilidad.validaciones.Lista;
import co.com.portabilidad.validaciones.Numero;
import lombok.Getter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Getter
public class Persona {

    private final String nombre;
    private final String apellido;
    private final BigInteger numeroCedula;
    private final String tipoCedula;
    private final List<Telefono> telefonos;
    private final List<Direccion> direcciones;

    private Persona(
            String nombre,
            String apellido,
            BigInteger numeroCedula,
            String tipoCedula,
            List<Telefono> telefonos,
            List<Direccion> direcciones,
            CadenaCaracter cadenaCaracter,
            Numero validadorNumero,
            Lista validadorLista
    ) {

        List<String> listadoExcepciones = new <String>ArrayList();

        this.validarCadenaCaracteres(listadoExcepciones, cadenaCaracter, nombre, apellido, tipoCedula);
        this.validarListas(listadoExcepciones, validadorLista, telefonos, direcciones);
        this.validarNumeros(listadoExcepciones, validadorNumero, numeroCedula);

        if (!listadoExcepciones.isEmpty()) {
            throw new ListadoExceptiones(listadoExcepciones);
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCedula = numeroCedula;
        this.tipoCedula = tipoCedula;
        this.telefonos = telefonos;
        this.direcciones = direcciones;
    }

    private void validarCadenaCaracteres(
            List<String> listadoExcepciones,
            CadenaCaracter cadenaCaracter,
            String nombre,
            String apellido,
            String tipoCedula
    ) {
        try {

            if (cadenaCaracter.cadenaVacia(nombre)) {
                listadoExcepciones.add(MensajesPersona.NOMBRE_VACIO);
            }

            if (cadenaCaracter.cadenaNula(nombre)) {
                listadoExcepciones.add(MensajesPersona.NOMBRE_NULO);
            }

            if (cadenaCaracter.cadenaVacia(apellido)) {
                listadoExcepciones.add(MensajesPersona.APELLIDO_VACIO);
            }

            if (cadenaCaracter.cadenaNula(apellido)) {
                listadoExcepciones.add(MensajesPersona.APELLIDO_NULO);
            }

            if (cadenaCaracter.cadenaVacia(tipoCedula)) {
                listadoExcepciones.add(MensajesPersona.TIPO_CEDULA_VACIO);
            }

            if (cadenaCaracter.cadenaNula(tipoCedula)) {
                listadoExcepciones.add(MensajesPersona.TIPO_CEDULA_NULO);
            }

        } catch (Exception e) {
            listadoExcepciones.add(MensajesPersona.CADENA_CARACTER_NULO);
        }
    }

    private void validarNumeros(
            List<String> listadoExcepciones,
            Numero validadorNumero,
            BigInteger numeroCedula
    ) {
        try {

            if (validadorNumero.numeroNegativo(numeroCedula)) {
                listadoExcepciones.add(MensajesPersona.NUMERO_CEDULA_NEGATIVO);
            }

            if (validadorNumero.numeroNulo(numeroCedula)) {
                listadoExcepciones.add(MensajesPersona.NUMERO_CEDULA_NULO);
            }

        } catch (Exception e) {
            listadoExcepciones.add(MensajesPersona.VALIDADOR_NUMERO_NULO);
        }
    }

    private void validarListas(
            List<String> listadoExcepciones,
            Lista validadorLista,
            List<Telefono> telefonos,
            List<Direccion> direcciones
    ) {
        try {

            if (validadorLista.listaVacia(telefonos)) {
                listadoExcepciones.add(MensajesPersona.TELEFONO_VACIO);
            }

            if (validadorLista.listaNula(telefonos)) {
                listadoExcepciones.add(MensajesPersona.TELEFONO_NULO);
            }

            if (validadorLista.listaVacia(direcciones)) {
                listadoExcepciones.add(MensajesPersona.DIRECCION_VACIA);
            }

            if (validadorLista.listaNula(direcciones)) {
                listadoExcepciones.add(MensajesPersona.DIRECCION_NULO);
            }

        } catch (Exception e) {
            listadoExcepciones.add(MensajesPersona.VALIDADOR_LISTA_NULO);
        }
    }

    public static PersonaBuilder builder() {
        return new PersonaBuilder();
    }

    public static class PersonaBuilder {

        private String nombre;
        private String apellido;
        private BigInteger numeroCedula;
        private String tipoCedula;
        private List<Telefono> telefonos;
        private List<Direccion> direcciones;
        private CadenaCaracter cadenaCaracter;
        private Numero validadorNumero;
        private Lista validadorLista;

        private PersonaBuilder() {
        }


        public PersonaBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public PersonaBuilder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public PersonaBuilder numeroCedula(BigInteger numeroCedula) {
            this.numeroCedula = numeroCedula;
            return this;
        }

        public PersonaBuilder tipoCedula(String tipoCedula) {
            this.tipoCedula = tipoCedula;
            return this;
        }

        public PersonaBuilder telefonos(List<Telefono> telefonos) {
            this.telefonos = telefonos;
            return this;
        }

        public PersonaBuilder direcciones(List<Direccion> direcciones) {
            this.direcciones = direcciones;
            return this;
        }

        public PersonaBuilder cadenaCaracter(CadenaCaracter cadenaCaracter) {
            this.cadenaCaracter = cadenaCaracter;
            return this;
        }

        public PersonaBuilder validadorNumero(Numero validadorNumero) {
            this.validadorNumero = validadorNumero;
            return this;
        }

        public PersonaBuilder validadorLista(Lista validadorLista) {
            this.validadorLista = validadorLista;
            return this;
        }

        public Persona build() {
            return new Persona(
                    this.nombre,
                    this.apellido,
                    this.numeroCedula,
                    this.tipoCedula,
                    this.telefonos,
                    this.direcciones,
                    this.cadenaCaracter,
                    this.validadorNumero,
                    this.validadorLista
            );
        }

    }

}
