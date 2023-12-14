package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import UnePiece.model.Partie;

public interface IDAOPartie extends JpaRepository<Partie,Integer> {

}
