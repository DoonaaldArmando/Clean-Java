package co.com.portabilidad.convertidores.implementacion;

import co.com.portabilidad.DTO.TelefonoDTO;
import co.com.portabilidad.clases.Telefono;
import co.com.portabilidad.convertidores.TelefonoConvertidor;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Numero;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class TelefonoConvertidorImplementacion implements TelefonoConvertidor {

    private final Numero validadorNumero;
    private final CadenaCaracter cadenaCaracter;

    @Override
    public Telefono telefonoDtoATelefono(TelefonoDTO telefonoDTO) {
        return Telefono
                .builder()
                .validadorNumero(validadorNumero)
                .cadenaCaracter(cadenaCaracter)
                .numero(telefonoDTO.getNumero())
                .indicativo(telefonoDTO.getIndicativo())
                .build();
    }
}
