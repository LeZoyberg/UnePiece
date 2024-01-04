package UnePiece.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import UnePiece.model.Ile;
import UnePiece.model.Mer;

public interface IDAOIle extends JpaRepository<Ile,Integer> {

@Query("SELECT i FROM Ile i WHERE i.mer = :mer AND i.ordre = :ordre")
    List<Ile> findAllByMerAndOrdre(@Param("mer") Mer mer, @Param("ordre") Integer ordre);

}
