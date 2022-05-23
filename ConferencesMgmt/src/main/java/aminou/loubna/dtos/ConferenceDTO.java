package aminou.loubna.dtos;


import java.util.List;

import lombok.Data;
import java.util.Date;


@Data
public class ConferenceDTO {
	public Long id;
	public String titre;
	public Date date;
	public Date heureDebit;
	public Date heureFin;
	public String description;
	SessionDTO sessionDTO;
	SpeakerDTO speakerDTO;
	ParticipantDTO participantDTO;
	CommentaireDTO commentaireDTO;
	List<CommentaireDTO> listCommentaireDTO;
}