package co.com.portabilidad.clases;


import co.com.portabilidad.excepciones.ListadoExceptiones;
import co.com.portabilidad.excepciones.StringNoVacio;
import co.com.portabilidad.excepciones.ValorRequerido;
import co.com.portabilidad.validaciones.CadenaCaracter;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
public class Direccion {

    private static final String CADENA_CARACTER_NULO = "La cadena caracter no puede ser nula";
    private static final String CIUDAD_NULA = "La ciudad no puede ser nula";
    private static final String CIUDAD_VACIA = "La ciudad no puede ser vacia";
    private static final String DEPARTAMENTO_NULO = "El departamento no puede ser nulo";
    private static final String DEPARTAMENTO_VACIO = "El departamento no puede estar vacio";
    private static final String UBICACION_NULA = "La ubicacion no puede ser nula";
    private static final String UBICACION_VACIA = "La ubicacion no puede ser vacia";

    private final String ciudad;
    private final String departamento;
    private final String ubicacion;

    private Direccion(
            String ciudad,
            String departamento,
            String ubicacion,
            CadenaCaracter cadenaCaracter
    ) {

        Boolean excepcionProducida = Boolean.FALSE;
        List<String> listadoExcepciones = new <String>ArrayList();

        try {

            if (cadenaCaracter.cadenaNoVacia(ciudad)) {
                listadoExcepciones.add(CIUDAD_VACIA);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoNula(ciudad)) {
                listadoExcepciones.add(CIUDAD_NULA);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoVacia(departamento)) {
                listadoExcepciones.add(DEPARTAMENTO_VACIO);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoNula(departamento)) {
                listadoExcepciones.add(DEPARTAMENTO_NULO);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoVacia(ubicacion)) {
                listadoExcepciones.add(UBICACION_VACIA);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoNula(ubicacion)) {
                listadoExcepciones.add(UBICACION_NULA);
                excepcionProducida = Boolean.TRUE;
            }

        } catch (Exception e) {
            listadoExcepciones.add(CADENA_CARACTER_NULO);
        }

        if (excepcionProducida) {
            throw new ListadoExceptiones(listadoExcepciones);
        }

        this.ciudad = ciudad;
        this.departamento = departamento;
        this.ubicacion = ubicacion;
    }

    public static DireccionBuilder builder() {
        return new DireccionBuilder();
    }

    public static class DireccionBuilder {

        private String ciudad;
        private String departamento;
        private String ubicacion;
        private CadenaCaracter cadenaCaracter;

        private DireccionBuilder() {
        }

        public DireccionBuilder ciudad(String ciudad) {
            this.ciudad = ciudad;
            return this;
        }

        public DireccionBuilder departamento(String departamento) {
            this.departamento = departamento;
            return this;
        }

        public DireccionBuilder ubicacion(String ubicacion) {
            this.ubicacion = ubicacion;
            return this;
        }

        public DireccionBuilder cadenaCaracter(CadenaCaracter cadenaCaracter) {
            this.cadenaCaracter = cadenaCaracter;
            return this;
        }

        public Direccion build() {
            return new Direccion(
                    this.ciudad,
                    this.departamento,
                    this.ubicacion,
                    this.cadenaCaracter
            );
        }

    }


}
