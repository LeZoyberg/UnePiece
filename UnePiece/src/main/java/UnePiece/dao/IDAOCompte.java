package UnePiece.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import UnePiece.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer> {

	@Query("SELECT c FROM Compte c WHERE c.login = ?1 and c.password = ?2")
	Optional<Compte> findByUsernameAndPassword(String username, String password);
}
