package co.com.portabilidad.excepciones;

public class ValorRequerido extends RuntimeException {

    public ValorRequerido(String message) {
        super(message);
    }
}
