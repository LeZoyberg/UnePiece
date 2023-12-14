package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import UnePiece.model.Membre;

public interface IDAOMembre extends JpaRepository<Membre,Integer> {

}
