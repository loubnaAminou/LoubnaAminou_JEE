package aminou.loubna.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
 import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Session{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String nom;
	@OneToMany(mappedBy = "session",fetch = FetchType.LAZY)
	List<Conference> listConference;
	@OneToOne
	Moderateur moderateur;
	@OneToOne
	Salle salle;
	@OneToOne
	Inscription inscription;
}