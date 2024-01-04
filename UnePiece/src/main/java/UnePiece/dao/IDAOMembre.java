package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import UnePiece.model.Membre;

public interface IDAOMembre extends JpaRepository<Membre,Integer> {

}
