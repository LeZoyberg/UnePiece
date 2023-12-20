package UnePiece.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
@Entity
@DiscriminatorValue("player")
public class Joueur extends Compte{

	public Joueur() {}

	public Joueur(String login, String password) {
		super(login, password);
	}
	
	
}
