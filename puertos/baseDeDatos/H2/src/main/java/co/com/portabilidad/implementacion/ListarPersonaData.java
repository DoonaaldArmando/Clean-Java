package co.com.portabilidad.implementacion;

import co.com.portabilidad.DAO.PersonaDAO;
import co.com.portabilidad.acciones.persona.ListaPersona;
import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.convertidor.PersonaConvertidor;
import co.com.portabilidad.repositorio.PersonaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@AllArgsConstructor
public class ListarPersonaData implements ListaPersona {

    private final PersonaRepositorio personaRepositorio;
    private final PersonaConvertidor personaConvertidor;

    @Override
    public Persona listarPorNumeroCedulaYTipoDocumento(String tipoDocumento, BigInteger numeroCedula) {
        PersonaDAO personaConsulta = this.personaRepositorio
                .findByNumeroCedulaAndTipoCedula(
                        numeroCedula,
                        tipoDocumento
                );
        return personaConvertidor.personaDataAPersona(personaConsulta);
    }

    @Override
    public List<Persona> listarTodos() {
        List<PersonaDAO> personaConsulta = this.personaRepositorio.findAll();
        return personaConsulta
                .stream()
                .map(personaConvertidor::personaDataAPersona)
                .collect(Collectors.toList());
    }
}
