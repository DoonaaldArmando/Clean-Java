package co.com.portabilidad.clases;


import co.com.portabilidad.excepciones.StringNoVacio;
import co.com.portabilidad.excepciones.ValorRequerido;
import co.com.portabilidad.validaciones.CadenaCaracter;
import lombok.Builder;

@Builder(toBuilder = true)
public class Direccion {

    private static final String OBLIGATORIO_GENERICO = "Se deben suministrar las instancias de todos los validadores";
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

        try {

            if (cadenaCaracter.cadenaNoVacia(ciudad)) {
                throw new StringNoVacio(CIUDAD_VACIA);
            }

            if (cadenaCaracter.cadenaNoNula(ciudad)) {
                throw new ValorRequerido(CIUDAD_NULA);
            }

            if (cadenaCaracter.cadenaNoVacia(departamento)) {
                throw new StringNoVacio(DEPARTAMENTO_VACIO);
            }

            if (cadenaCaracter.cadenaNoNula(departamento)) {
                throw new ValorRequerido(DEPARTAMENTO_NULO);
            }

            if (cadenaCaracter.cadenaNoVacia(ubicacion)) {
                throw new StringNoVacio(UBICACION_VACIA);
            }

            if (cadenaCaracter.cadenaNoNula(ubicacion)) {
                throw new ValorRequerido(UBICACION_NULA);
            }

        } catch (Exception e) {
            throw new ValorRequerido(OBLIGATORIO_GENERICO);
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
