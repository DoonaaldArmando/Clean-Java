package co.com.portabilidad.persona;


import co.com.portabilidad.DTO.PersonaDTO;
import co.com.portabilidad.acciones.persona.crear.CrearPersona;
import co.com.portabilidad.acciones.persona.listar.ListarPersona;
import co.com.portabilidad.clases.Persona;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/personas")
@AllArgsConstructor
@Repository
public class PersonaController {

    private CrearPersona crearPersona;
    private ListarPersona listarPersona;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> crearPersona(@RequestBody PersonaDTO persona) {
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
                                persona.getTelefonos(),
                                persona.getDirecciones()
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
