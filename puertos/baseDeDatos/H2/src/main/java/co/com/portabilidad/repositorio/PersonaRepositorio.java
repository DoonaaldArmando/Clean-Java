package co.com.portabilidad.repositorio;

import co.com.portabilidad.DAO.PersonaDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface PersonaRepositorio extends JpaRepository<PersonaDAO, String> {

    PersonaDAO findByNumeroCedulaAndTipoCedula(BigInteger numeroCedula, String tipoCedula);

}
