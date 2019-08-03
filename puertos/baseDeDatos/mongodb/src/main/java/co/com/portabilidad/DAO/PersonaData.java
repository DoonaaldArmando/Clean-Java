package co.com.portabilidad.DAO;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Document(collection = "persona")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class PersonaData {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private BigInteger numeroCedula;
    private String tipoCedula;
    private List<TelefonoData> telefonos;
    private List<DireccionData> direcciones;

}
