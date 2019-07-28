package co.com.portabilidad.clases;

import co.com.portabilidad.excepciones.ListaNoVacia;
import co.com.portabilidad.excepciones.NumeroNegativo;
import co.com.portabilidad.excepciones.StringNoVacio;
import co.com.portabilidad.excepciones.ValorRequerido;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Lista;
import co.com.portabilidad.validaciones.Numero;
import lombok.Builder;

import java.math.BigInteger;
import java.util.List;


public class Persona {

    private static final String OBLIGATORIO_GENERICO = "Se deben suministrar las instancias de todos los validadores";
    private static final String NOMBRE_NULO = "El nombre no puede ser nulo";
    private static final String NOMBRE_VACIO = "El nombre no puede ser vacio";
    private static final String APELLIDO_NULO = "El apellido no puede ser nulo";
    private static final String APELLIDO_VACIO = "El apellido no puede ser vacio";
    private static final String TIPO_CEDULA_NULO = "El tipo de cedula no puede ser nulo";
    private static final String TIPO_CEDULA_VACIO = "El tipo de cedula no puede ser vacio";
    private static final String NUMERO_CEDULA_NULO = "EL numero de cedula no puede ser nulo";
    private static final String NUMERO_CEDULA_NEGATIVO = "EL numero de cedula no puede ser negativo";
    private static final String TELEFONO_NULO = "El telefono no puede ser nulo";
    private static final String TELEFONO_VACIO = "Se debe ingresar almenos un telefono";
    private static final String DIRECCION_NULO = "La direccion no puede ser nula";
    private static final String DIRECCION_VACIA = "Se debe ingresar almenos una direccion";


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

        try {

            if (cadenaCaracter.cadenaNoVacia(nombre)) {
                throw new StringNoVacio(NOMBRE_VACIO);
            }

            if (cadenaCaracter.cadenaNoNula(nombre)) {
                throw new ValorRequerido(NOMBRE_NULO);
            }

            if (cadenaCaracter.cadenaNoVacia(apellido)) {
                throw new StringNoVacio(APELLIDO_VACIO);
            }

            if (cadenaCaracter.cadenaNoNula(apellido)) {
                throw new ValorRequerido(APELLIDO_NULO);
            }

            if (cadenaCaracter.cadenaNoVacia(tipoCedula)) {
                throw new StringNoVacio(TIPO_CEDULA_VACIO);
            }

            if (cadenaCaracter.cadenaNoNula(tipoCedula)) {
                throw new ValorRequerido(TIPO_CEDULA_NULO);
            }

            if (validadorNumero.numeroNoNegativo(numeroCedula)) {
                throw new NumeroNegativo(NUMERO_CEDULA_NEGATIVO);
            }

            if (validadorNumero.numeroNoNulo(numeroCedula)) {
                throw new ValorRequerido(NUMERO_CEDULA_NULO);
            }

            if (validadorLista.listaNoVacia(telefonos)) {
                throw new ListaNoVacia(TELEFONO_VACIO);
            }

            if (validadorLista.listaNoNula(telefonos)) {
                throw new ValorRequerido(TELEFONO_NULO);
            }

            if (validadorLista.listaNoVacia(direcciones)) {
                throw new ListaNoVacia(DIRECCION_VACIA);
            }

            if (validadorLista.listaNoNula(direcciones)) {
                throw new ValorRequerido(DIRECCION_NULO);
            }


        } catch (Exception e) {
            throw new ValorRequerido(OBLIGATORIO_GENERICO);
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCedula = numeroCedula;
        this.tipoCedula = tipoCedula;
        this.telefonos = telefonos;
        this.direcciones = direcciones;
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
                    this.validadorLista);
        }

    }

}
