package co.com.portabilidad.DAO;

import lombok.*;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class TelefonoData {

    private String indicativo;
    private BigInteger numero;

}
