package co.com.portabilidad.DTO;

import co.com.portabilidad.clases.Direccion;
import co.com.portabilidad.clases.Telefono;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PersonaDTO {

    private String nombre;

    private String apellido;

    @NotNull(message = "Numero de cedula Requerido")
    private BigInteger numeroCedula;

    @NotNull(message = "Tipo de cedula Requerido")
    private String tipoCedula;

    private List<Telefono> telefonos;

    private List<Direccion> direcciones;

}
