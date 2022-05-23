package aminou.loubna.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue(value = "Speaker")
public class Speaker extends Participant{
	public String lienProfil;
	@OneToOne
	Conference conference;
}