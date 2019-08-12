package co.com.portabilidad.convertidor.implementacion;

import co.com.portabilidad.DAO.PersonaDAO;
import co.com.portabilidad.clases.Persona;
import co.com.portabilidad.convertidor.DireccionConvertidor;
import co.com.portabilidad.convertidor.PersonaConvertidor;
import co.com.portabilidad.convertidor.TelefonoConvertidor;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Lista;
import co.com.portabilidad.validaciones.Numero;
import lombok.AllArgsConstructor;

import java.util.stream.Collectors;

@AllArgsConstructor
public class PersonaImplementacion implements PersonaConvertidor {

    private final CadenaCaracter cadenaCaracter;
    private final Numero validadorNumero;
    private final Lista validadorLista;
    private final TelefonoConvertidor telefonoConvertidor;
    private final DireccionConvertidor direccionConvertidor;

    @Override
    public Persona personaDataAPersona(PersonaDAO personaData) {
        return Persona
                .builder()
                .validadorLista(validadorLista)
                .validadorNumero(validadorNumero)
                .cadenaCaracter(cadenaCaracter)
                .tipoCedula(personaData.getTipoCedula())
                .telefonos(
                        personaData
                                .getTelefonos()
                                .stream()
                                .map(telefonoConvertidor::telefonoDataATelefono)
                                .collect(Collectors.toList())
                )
                .nombre(personaData.getNombre())
                .numeroCedula(personaData.getNumeroCedula())
                .direcciones(
                        personaData
                                .getDirecciones()
                                .stream()
                                .map(direccionConvertidor::direccionDataADireccion)
                                .collect(Collectors.toList())
                )
                .apellido(personaData.getApellido())
                .build();
    }

    @Override
    public PersonaDAO personaAPersonaData(Persona persona) {
        return PersonaDAO
                .builder()
                .apellido(persona.getApellido())
                .nombre(persona.getNombre())
                .numeroCedula(persona.getNumeroCedula())
                .tipoCedula(persona.getTipoCedula())
                .direcciones(
                        persona
                                .getDirecciones()
                                .stream()
                                .map(direccionConvertidor::direccionADireccionData)
                                .collect(Collectors.toSet())
                )
                .telefonos(
                        persona
                                .getTelefonos()
                                .stream()
                                .map(telefonoConvertidor::telefonoATelefonoData)
                                .collect(Collectors.toSet())
                )
                .build();

    }

}
