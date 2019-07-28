package co.com.portabilidad.excepciones.mensajes;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MensajesTelefono extends MensajesGenerales {

    public static final String INDICATIVO_NULL = "El indicativo no puede ser nulo";
    public static final String INDICATIVO_VACIO = "El indicativo no puede ser vacio";
    public static final String NUMERO_NULL = "El numero no puede ser nulo";
    public static final String NUMERO_NEGATIVO = "El numero no puede ser negativo o cero";
    public static final String CADENA_CARACTER_NULO = "La cadena caracter no puede ser nula";
    public static final String VALIDADOR_NUMERO_NULO = "El validador numero no puede ser nulo";

}
