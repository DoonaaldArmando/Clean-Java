package co.com.portabilidad.DTO;

import co.com.portabilidad.clases.Direccion;
import co.com.portabilidad.clases.Telefono;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Lista;
import co.com.portabilidad.validaciones.Numero;
import lombok.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private BigInteger numeroCedula;
    private String tipoCedula;
    private List<Telefono> telefonos;
    private List<Direccion> direcciones;

}
