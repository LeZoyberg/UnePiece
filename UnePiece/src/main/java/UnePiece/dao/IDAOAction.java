package UnePiece.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import UnePiece.model.Action;

public interface IDAOAction extends JpaRepository<Action,Integer>{

@Query("SELECT a FROM Action a JOIN FETCH a.partie WHERE a.partie.id = :partieId AND a.termine = false")
	List<Action> findAllWithPartie(@Param("partieId") Integer id);
}
