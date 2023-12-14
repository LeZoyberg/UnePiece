package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import UnePiece.model.Pirate;


public interface IDAOPirate extends JpaRepository<Pirate,Integer> {

}
