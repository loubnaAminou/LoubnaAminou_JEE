package aminou.loubna.entities;

import aminou.loubna.enums.Sexe;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ROLE", length = 10, discriminatorType = DiscriminatorType.STRING)
public class Participant{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String nom;
	public String email;
	public String photo;
	@Enumerated(EnumType.STRING)
	public Sexe genre;
	@OneToOne
	Conference conference;
	@OneToOne
	Commentaire commentaire;
}