package aminou.loubna.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
 import java.util.List;

@Data
@Entity
@DiscriminatorValue(value = "Invite")
public class Invite extends Participant{
	public String affiliation;
	@OneToMany(mappedBy = "invite",fetch = FetchType.LAZY)
	List<Inscription> listInscription;
}