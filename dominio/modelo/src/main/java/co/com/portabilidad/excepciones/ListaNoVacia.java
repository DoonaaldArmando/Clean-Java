package co.com.portabilidad.excepciones;

public class ListaNoVacia extends RuntimeException {

    public ListaNoVacia(String message) {
        super(message);
    }
}
