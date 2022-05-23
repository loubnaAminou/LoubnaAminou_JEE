package aminou.loubna.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Salle{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String nom;
	@OneToOne
	Session session;
}