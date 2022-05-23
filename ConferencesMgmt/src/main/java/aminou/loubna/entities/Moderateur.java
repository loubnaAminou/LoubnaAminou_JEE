package aminou.loubna.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue(value = "Moderateur")
public class Moderateur extends Participant{
	public String specialite;
	@OneToOne
	Session session;
}