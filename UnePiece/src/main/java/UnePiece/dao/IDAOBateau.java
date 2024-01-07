package UnePiece.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import UnePiece.model.Bateau;

public interface IDAOBateau extends JpaRepository<Bateau, Integer> {

    @Query("SELECT b FROM Bateau b WHERE b.tier = :tier")
    List<Bateau> findAllByTier(@Param("tier") int tier);

    @Query("SELECT b FROM Bateau b WHERE b.tier = :tier1 OR b.tier = :tier2")
    List<Bateau> findAllByTierOrTier(@Param("tier1") int tier, @Param("tier2") int tier2);

}
