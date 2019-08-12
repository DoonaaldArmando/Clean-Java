package co.com.portabilidad.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

@Entity
@Table(name = "Direccion")
public class DireccionDAO {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Ciudad")
    private String ciudad;

    @Column(name = "Departamento")
    private String departamento;

    @Column(name = "Ubicacion")
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private PersonaDAO personaDAO;

}
