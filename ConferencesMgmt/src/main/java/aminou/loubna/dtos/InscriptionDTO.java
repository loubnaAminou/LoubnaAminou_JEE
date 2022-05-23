package aminou.loubna.dtos;


import lombok.Data;
import java.util.Date;


@Data
public class InscriptionDTO {
	public Long id;
	public Date date;
	public String statut;
	public double prix;
	InviteDTO inviteDTO;
	SessionDTO sessionDTO;
}