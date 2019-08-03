package co.com.portabilidad;


import co.com.portabilidad.acciones.persona.ExistenciaPersona;
import co.com.portabilidad.acciones.persona.GuardarPersona;
import co.com.portabilidad.acciones.persona.ListaPersona;
import co.com.portabilidad.acciones.persona.crear.CrearPersona;
import co.com.portabilidad.acciones.persona.lista.ListarPersona;
import co.com.portabilidad.acciones.persona.crear.CrearPersonaImplementacion;
import co.com.portabilidad.acciones.persona.lista.ListarPersonaImplementacion;
import co.com.portabilidad.convertidor.DireccionConvertidor;
import co.com.portabilidad.convertidor.PersonaConvertidor;
import co.com.portabilidad.convertidor.TelefonoConvertidor;
import co.com.portabilidad.convertidor.implementacion.DireccionConvertidorImplementacion;
import co.com.portabilidad.convertidor.implementacion.PersonaConvertidorImplementacion;
import co.com.portabilidad.convertidor.implementacion.TelefonoConvertidorImplementacion;
import co.com.portabilidad.fabricas.PersonaFabrica;
import co.com.portabilidad.implementacion.persona.ExistenciaPersonaData;
import co.com.portabilidad.validaciones.CadenaCaracter;
import co.com.portabilidad.validaciones.Lista;
import co.com.portabilidad.validaciones.Numero;
import co.com.portabilidad.validaciones.implementacion.CadenaCaracterImplementacion;
import co.com.portabilidad.validaciones.implementacion.ListaImplementacion;
import co.com.portabilidad.validaciones.implementacion.NumeroImplementacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

@Configuration
public class ConfiguracionPrincipal {


    @Bean
    public CadenaCaracter cadenaCaracter() {
        return new CadenaCaracterImplementacion();
    }

    @Bean
    public Lista lista() {
        return new ListaImplementacion();
    }

    @Bean
    public Numero numero() {
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
    public CrearPersona crearPersona(
            PersonaFabrica personaFabrica,
            GuardarPersona guardarPersona,
            ExistenciaPersona existenciaPersona) {
        return new CrearPersonaImplementacion(
                personaFabrica,
                guardarPersona,
                existenciaPersona);
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
            ListaPersona listaPersona
    ) {
        return new ListarPersonaImplementacion(listaPersona);
    }

    @Bean
    public ListarPersona listarPersona(ListaPersona listaPersona) {
        return new ListarPersonaImplementacion(listaPersona);
    }

    @Bean
    public PersonaConvertidor personaConvertidor(
            CadenaCaracter cadenaCaracter,
            Numero validadorNumero,
            Lista validadorLista,
            TelefonoConvertidor telefonoConvertidor,
            DireccionConvertidor direccionConvertidor
    ) {
        return new PersonaConvertidorImplementacion(
                cadenaCaracter,
                validadorNumero,
                validadorLista,
                telefonoConvertidor,
                direccionConvertidor
        );
    }

    @Bean
    public TelefonoConvertidor telefonoConvertidor(
            CadenaCaracter cadenaCaracter,
            Numero validadorNumero) {
        return new TelefonoConvertidorImplementacion(cadenaCaracter, validadorNumero);
    }

    @Bean
    public DireccionConvertidor direccionConvertidor(
            CadenaCaracter cadenaCaracter
    ) {
        return new DireccionConvertidorImplementacion(cadenaCaracter);
    }

    @Bean
    public ExistenciaPersona existenciaPersona(MongoOperations mongoOperations) {
        return new ExistenciaPersonaData(mongoOperations);
    }
}
