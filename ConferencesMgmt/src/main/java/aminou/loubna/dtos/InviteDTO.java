package aminou.loubna.dtos;


import java.util.List;
import lombok.Data;


@Data
public class InviteDTO {
	public String affiliation;
	List<InscriptionDTO> listInscriptionDTO;
}