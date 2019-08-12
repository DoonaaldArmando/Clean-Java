package co.com.portabilidad.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

@Entity
@Table(name = "Telefono")
public class TelefonoDAO {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Indicativo")
    private String indicativo;

    @Column(name = "Numero")
    private BigInteger numero;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private PersonaDAO personaDAO;

}
