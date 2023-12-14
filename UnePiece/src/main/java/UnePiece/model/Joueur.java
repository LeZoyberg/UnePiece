package UnePiece.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
@Entity
@DiscriminatorValue("player")
public class Joueur extends Compte{

}
