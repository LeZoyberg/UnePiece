package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import UnePiece.model.evenement.Evenement;

public interface IDAOEvenement extends JpaRepository<Evenement,Integer> {

}
