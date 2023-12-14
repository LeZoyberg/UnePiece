package UnePiece.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte{
	
}
