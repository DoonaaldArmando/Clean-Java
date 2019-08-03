package co.com.portabilidad.convertidor.implementacion;

import co.com.portabilidad.DAO.TelefonoData;
import co.com.portabilidad.clases.Telefono;
import co.com.portabilidad.convertidor.TelefonoConvertidor;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Numero;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TelefonoConvertidorImplementacion implements TelefonoConvertidor {

    private final CadenaCaracter cadenaCaracter;
    private final Numero validadorNumero;

    @Override
    public Telefono telefonoDataATelefono(TelefonoData telefonoData) {
        return Telefono
                .builder()
                .cadenaCaracter(cadenaCaracter)
                .indicativo(telefonoData.getIndicativo())
                .numero(telefonoData.getNumero())
                .validadorNumero(validadorNumero)
                .build();
    }

    @Override
    public TelefonoData telefonoATelefonoData(Telefono telefono) {
        return TelefonoData
                .builder()
                .indicativo(telefono.getIndicativo())
                .numero(telefono.getNumero())
                .build();
    }
}
