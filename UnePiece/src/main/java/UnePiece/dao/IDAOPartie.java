package UnePiece.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import UnePiece.model.Compte;
import UnePiece.model.Partie;

public interface IDAOPartie extends JpaRepository<Partie,Integer> {

	@Query("SELECT p FROM Partie p WHERE p.joueur.id = ?1 and p.termine = false")
	Optional<Partie> findByIdJoueur(Integer id);
	
	@Query("SELECT p FROM Partie p JOIN FETCH p.membres WHERE p.joueur.id = ?1 and p.termine = false")
	Optional<Partie> findByIdJoueurWithMembres(Integer id);

	List<Partie> findAllByOrderByDureeDesc();
}
