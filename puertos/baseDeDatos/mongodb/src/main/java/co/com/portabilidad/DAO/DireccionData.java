package co.com.portabilidad.DAO;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class DireccionData {

    private String ciudad;
    private String departamento;
    private String ubicacion;

}
