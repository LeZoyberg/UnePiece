package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import UnePiece.model.Event;

public interface IDAOEvenement extends JpaRepository<Event,Integer> {

}
