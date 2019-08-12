package co.com.portabilidad.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

@Entity
@Table(name = "Persona")
public class PersonaDAO {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Numero_Cedula")
    private BigInteger numeroCedula;

    @Column(name = "Tipo_Cedula")
    private String tipoCedula;

    @OneToMany(mappedBy = "persona")
    private Set<TelefonoDAO> telefonos;

    @OneToMany(mappedBy = "persona")
    private Set<DireccionDAO> direcciones;

}
