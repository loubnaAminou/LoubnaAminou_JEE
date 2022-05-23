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
 import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conference{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String titre;
	@Temporal(TemporalType.DATE)
	public Date date;
	public String heureDebit;
	public String heureFin;
	public String description;
	@ManyToOne
	Session session;
	@OneToOne
	Speaker speaker;
	@OneToOne
	Participant participant;
	@OneToMany(mappedBy = "conference",fetch = FetchType.LAZY)
	List<Commentaire> listCommentaire;
}