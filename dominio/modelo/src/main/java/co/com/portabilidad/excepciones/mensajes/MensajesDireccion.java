package co.com.portabilidad.excepciones.mensajes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MensajesDireccion extends MensajesGenerales {

    public static final String CADENA_CARACTER_NULO = "La cadena caracter no puede ser nula";
    public static final String CIUDAD_NULA = "La ciudad no puede ser nula";
    public static final String CIUDAD_VACIA = "La ciudad no puede ser vacia";
    public static final String DEPARTAMENTO_NULO = "El departamento no puede ser nulo";
    public static final String DEPARTAMENTO_VACIO = "El departamento no puede estar vacio";
    public static final String UBICACION_NULA = "La ubicacion no puede ser nula";
    public static final String UBICACION_VACIA = "La ubicacion no puede ser vacia";

}
