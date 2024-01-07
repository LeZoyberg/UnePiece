package UnePiece.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import UnePiece.model.Pirate;

public interface IDAOPirate extends JpaRepository<Pirate, Integer> {

    @Query("SELECT p FROM Pirate p WHERE p.capitaine = FALSE")
    List<Pirate> findAllNotCapitaine();

    @Query("SELECT p FROM Pirate p WHERE p.tier = :tier")
    List<Pirate> findAllByTier(@Param("tier") int tier);

    @Query("SELECT p FROM Pirate p WHERE p.tier = :tier1 OR p.tier = :tier2")
    List<Pirate> findAllByTierOrTier(@Param("tier1") int tier, @Param("tier2") int tier2);

}
