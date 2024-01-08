package UnePiece.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import UnePiece.model.Partie;

public interface IDAOPartie extends JpaRepository<Partie,Integer> {

	@Query("SELECT p FROM Partie p WHERE p.joueur.id = ?1 and p.termine = false")
	Optional<Partie> findByIdJoueur(Integer id);
	
	@Query("SELECT p FROM Partie p JOIN FETCH p.membres WHERE p.joueur.id = ?1 and p.termine = false")
	Optional<Partie> findByIdJoueurWithMembres(Integer id);

	// @Query("SELECT p FROM Partie p JOIN FETCH p.actions WHERE p.joueur.id = ?1 and p.termine = false")
	// Optional<Partie> findByIdJoueurWithActions(Integer id);
	// essayer de choper les parties termiénes ? ou top 10 ?
	List<Partie> findAllByOrderByDureeDesc();

	@Query("SELECT p from Partie p WHERE p.joueur.id = ?1")
	List<Partie> findAllByIdJoueur(Integer id);
}
