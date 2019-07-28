package co.com.portabilidad.excepciones.mensajes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MensajesPersona extends MensajesGenerales {

    public static final String NOMBRE_NULO = "El nombre no puede ser nulo";
    public static final String NOMBRE_VACIO = "El nombre no puede ser vacio";
    public static final String APELLIDO_NULO = "El apellido no puede ser nulo";
    public static final String APELLIDO_VACIO = "El apellido no puede ser vacio";
    public static final String TIPO_CEDULA_NULO = "El tipo de cedula no puede ser nulo";
    public static final String TIPO_CEDULA_VACIO = "El tipo de cedula no puede ser vacio";
    public static final String NUMERO_CEDULA_NULO = "EL numero de cedula no puede ser nulo";
    public static final String NUMERO_CEDULA_NEGATIVO = "EL numero de cedula no puede ser negativo";
    public static final String TELEFONO_NULO = "El telefono no puede ser nulo";
    public static final String TELEFONO_VACIO = "Se debe ingresar almenos un telefono";
    public static final String DIRECCION_NULO = "La direccion no puede ser nula";
    public static final String DIRECCION_VACIA = "Se debe ingresar almenos una direccion";

}
