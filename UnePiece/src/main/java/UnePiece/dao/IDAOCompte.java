package UnePiece.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import UnePiece.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer> {

}
