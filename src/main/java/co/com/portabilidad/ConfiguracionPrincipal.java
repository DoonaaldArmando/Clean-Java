package co.com.portabilidad;


import co.com.portabilidad.acciones.persona.ExistenciaPersona;
import co.com.portabilidad.acciones.persona.GuardarPersona;
import co.com.portabilidad.acciones.persona.crear.CrearPersona;
import co.com.portabilidad.acciones.persona.crear.CrearPersonaImplementacion;
import co.com.portabilidad.acciones.persona.listar.ListarPersonaImplementacion;
import co.com.portabilidad.fabricas.PersonaFabrica;
import co.com.portabilidad.implementacion.persona.CrearPersonaData;
import co.com.portabilidad.implementacion.persona.ListarPersonaData;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Lista;
import co.com.portabilidad.validaciones.Numero;
import co.com.portabilidad.validaciones.implementacion.CadenaCaracterImplementacion;
import co.com.portabilidad.validaciones.implementacion.ListaImplementacion;
import co.com.portabilidad.validaciones.implementacion.NumeroImplementacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionPrincipal {


    @Bean
    public CadenaCaracterImplementacion cadenaCaracter() {
        return new CadenaCaracterImplementacion();
    }

    @Bean
    public ListaImplementacion lista() {
        return new ListaImplementacion();
    }

    @Bean
    public NumeroImplementacion numero() {
        return new NumeroImplementacion();
    }


    @Bean
    public PersonaFabrica personaFabrica(
            CadenaCaracter cadenaCaracter,
            Numero numero,
            Lista lista
    ) {
        return new PersonaFabrica(cadenaCaracter, numero, lista);
    }

    @Bean
    public CrearPersona crearPersona(PersonaFabrica personaFabrica,
                                     GuardarPersona guardarPersona,
                                     ExistenciaPersona existenciaPersona) {
        return new CrearPersonaImplementacion(
                personaFabrica,
                guardarPersona,
                existenciaPersona);
    }


    @Bean
    public CrearPersonaData crearPersonaData() {
        return new CrearPersonaData();
    }

    @Bean
    public ListarPersonaData listarPersonaData() {
        return new ListarPersonaData();
    }

    @Bean
    public CrearPersonaImplementacion crearPersonaImplementacion(
            PersonaFabrica personaFabrica,
            GuardarPersona guardarPersona,
            ExistenciaPersona existenciaPersona
    ) {
        return new CrearPersonaImplementacion(personaFabrica, guardarPersona, existenciaPersona);
    }

    @Bean
    public ListarPersonaImplementacion listarPersonaImplementacion(
            co.com.portabilidad.acciones.persona.ListarPersona listarPersona
    ) {
        return new ListarPersonaImplementacion(listarPersona);
    }

}
