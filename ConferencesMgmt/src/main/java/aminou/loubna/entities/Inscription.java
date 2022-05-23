package aminou.loubna.entities;

import aminou.loubna.enums.StatutInscription;
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
public class Inscription{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Temporal(TemporalType.DATE)
	public Date date;
	@Enumerated(EnumType.STRING)
	public StatutInscription statut;
	public double prix;
	@ManyToOne
	Invite invite;
	@OneToOne
	Session session;
}