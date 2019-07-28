package co.com.portabilidad.excepciones;

public class StringNoVacio extends RuntimeException {

    public StringNoVacio(String message) {
        super(message);
    }
}
