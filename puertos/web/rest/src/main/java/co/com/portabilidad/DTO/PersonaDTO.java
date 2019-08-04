package co.com.portabilidad.DTO;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class PersonaDTO {

    private String nombre;

    private String apellido;

    @NotNull(message = "Numero de cedula Requerido")
    private BigInteger numeroCedula;

    @NotNull(message = "Tipo de cedula Requerido")
    private String tipoCedula;

    private List<TelefonoDTO> telefonos;

    private List<DireccionDTO> direcciones;

}
