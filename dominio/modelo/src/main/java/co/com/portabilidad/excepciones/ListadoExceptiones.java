package co.com.portabilidad.excepciones;

import java.util.List;

public class ListadoExceptiones extends RuntimeException {

    public ListadoExceptiones(List<String> mensajes) {
        super(String.join("/n", mensajes));
    }
}
