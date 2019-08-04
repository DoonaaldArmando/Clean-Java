package co.com.portabilidad.DTO;

import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TelefonoDTO {

    private String indicativo;
    private BigInteger numero;

}
