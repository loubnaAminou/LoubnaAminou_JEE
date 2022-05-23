package aminou.loubna.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commentaire{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Temporal(TemporalType.DATE)
	public Date date;
	public String contenu;
	public int nombreLikes;
	@ManyToOne
	Conference conference;
	@OneToOne
	Participant participant;
}