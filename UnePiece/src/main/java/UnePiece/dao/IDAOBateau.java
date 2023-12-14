package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import UnePiece.model.Bateau;

public interface IDAOBateau extends JpaRepository<Bateau,Integer> {

}
