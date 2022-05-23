package aminou.loubna.dtos;


import lombok.Data;
import java.util.Date;


@Data
public class CommentaireDTO {
	public Long id;
	public Date date;
	public String contenu;
	public int nombreLikes;
	ConferenceDTO conferenceDTO;
	ParticipantDTO participantDTO;
}