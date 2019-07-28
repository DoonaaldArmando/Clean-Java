package co.com.portabilidad.clases;


import co.com.portabilidad.excepciones.ListadoExceptiones;
import co.com.portabilidad.excepciones.mensajes.MensajesDireccion;
import co.com.portabilidad.validaciones.CadenaCaracter;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
public class Direccion {


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
                listadoExcepciones.add(MensajesDireccion.CIUDAD_VACIA);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoNula(ciudad)) {
                listadoExcepciones.add(MensajesDireccion.CIUDAD_NULA);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoVacia(departamento)) {
                listadoExcepciones.add(MensajesDireccion.DEPARTAMENTO_VACIO);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoNula(departamento)) {
                listadoExcepciones.add(MensajesDireccion.DEPARTAMENTO_NULO);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoVacia(ubicacion)) {
                listadoExcepciones.add(MensajesDireccion.UBICACION_VACIA);
                excepcionProducida = Boolean.TRUE;
            }

            if (cadenaCaracter.cadenaNoNula(ubicacion)) {
                listadoExcepciones.add(MensajesDireccion.UBICACION_NULA);
                excepcionProducida = Boolean.TRUE;
            }

        } catch (Exception e) {
            listadoExcepciones.add(MensajesDireccion.CADENA_CARACTER_NULO);
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
