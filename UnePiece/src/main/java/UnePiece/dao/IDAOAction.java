package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import UnePiece.model.Action;

public interface IDAOAction extends JpaRepository<Action,Integer>{

}
