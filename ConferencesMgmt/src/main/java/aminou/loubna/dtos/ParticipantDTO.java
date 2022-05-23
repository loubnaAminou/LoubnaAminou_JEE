package aminou.loubna.dtos;


import lombok.Data;


@Data
public class ParticipantDTO {
	public Long id;
	public String nom;
	public String email;
	public String photo;
	public String genre;
	ConferenceDTO conferenceDTO;
	CommentaireDTO commentaireDTO;
}