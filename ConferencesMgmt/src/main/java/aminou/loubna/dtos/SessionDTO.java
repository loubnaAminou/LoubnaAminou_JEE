package aminou.loubna.dtos;


import java.util.List;

import lombok.Data;


@Data
public class SessionDTO {
	public Long id;
	public String nom;
	List<ConferenceDTO> listConferenceDTO;
	ModerateurDTO moderateurDTO;
	SalleDTO salleDTO;
	InscriptionDTO inscriptionDTO;
}