package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import UnePiece.model.Event;

public interface IDAOEvent extends JpaRepository<Event,Integer> {

}
