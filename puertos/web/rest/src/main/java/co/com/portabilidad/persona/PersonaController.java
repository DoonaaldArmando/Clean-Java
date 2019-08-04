package co.com.portabilidad.persona;


import co.com.portabilidad.DTO.PersonaDTO;
import co.com.portabilidad.acciones.persona.crear.CrearPersona;
import co.com.portabilidad.acciones.persona.lista.ListarPersona;
import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.convertidores.DireccionConvertidor;
import co.com.portabilidad.convertidores.TelefonoConvertidor;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/personas")
@AllArgsConstructor
public class PersonaController {

    private final CrearPersona crearPersona;
    private final ListarPersona listarPersona;
    private final TelefonoConvertidor telefonoConvertidor;
    private final DireccionConvertidor direccionConvertidor;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> crearPersona(@Valid @RequestBody PersonaDTO persona) {
        return ResponseEntity
                .created(
                        URI.create(
                                "personas/"
                                        .concat(persona.getTipoCedula())
                                        .concat("/")
                                        .concat(persona.getNumeroCedula().toString())
                        )
                )
                .body(
                        this.crearPersona.crearPersona(
                                persona.getNombre(),
                                persona.getApellido(),
                                persona.getNumeroCedula(),
                                persona.getTipoCedula(),
                                persona.getTelefonos()
                                        .stream()
                                        .map(telefonoConvertidor::telefonoDtoATelefono)
                                        .collect(Collectors.toList()),
                                persona.getDirecciones()
                                        .stream()
                                        .map(direccionConvertidor::direccionDtoADireccion)
                                        .collect(Collectors.toList())
                        )
                );
    }


    @GetMapping(path = "/{tipoDocumento}/{numeroCedula}")
    public ResponseEntity<Persona> consultarPersonaPorTipoDocumentoYNumeroCedula(
            @PathVariable String tipoDocumento,
            @PathVariable BigInteger numeroCedula
    ) {
        return ResponseEntity
                .ok()
                .body(
                        this.listarPersona.listarPorNumeroCedulaYTipoCedula(tipoDocumento, numeroCedula)
                );
    }

    @GetMapping()
    public ResponseEntity<List<Persona>> consultarPersona() {
        return ResponseEntity.ok().body(this.listarPersona.listarTodos());
    }


}
