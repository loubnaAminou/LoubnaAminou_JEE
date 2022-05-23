package aminou.loubna.mappers;
import aminou.loubna.entities.Commentaire;
import aminou.loubna.dtos.CommentaireDTO;
import aminou.loubna.entities.Inscription;
import aminou.loubna.dtos.InscriptionDTO;
import aminou.loubna.entities.Invite;
import aminou.loubna.dtos.InviteDTO;
import aminou.loubna.entities.Speaker;
import aminou.loubna.dtos.SpeakerDTO;
import aminou.loubna.entities.Moderateur;
import aminou.loubna.dtos.ModerateurDTO;
import aminou.loubna.entities.Participant;
import aminou.loubna.dtos.ParticipantDTO;
import aminou.loubna.entities.Salle;
import aminou.loubna.dtos.SalleDTO;
import aminou.loubna.entities.Conference;
import aminou.loubna.dtos.ConferenceDTO;
import aminou.loubna.entities.Session;
import aminou.loubna.dtos.SessionDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class MapperImpl{
	public CommentaireDTO fromCommentaire(Commentaire commentaire){
		CommentaireDTO commentairedto = new CommentaireDTO();
		BeanUtils.copyProperties(commentaire, commentairedto);
		return commentairedto;
	}
	public Commentaire fromCommentaireDTO(CommentaireDTO commentairedto){
 		Commentaire commentaire = new Commentaire();
		BeanUtils.copyProperties(commentairedto, commentaire);
		return commentaire;
	}
	public InscriptionDTO fromInscription(Inscription inscription){
		InscriptionDTO inscriptiondto = new InscriptionDTO();
		BeanUtils.copyProperties(inscription, inscriptiondto);
		return inscriptiondto;
	}
	public Inscription fromInscriptionDTO(InscriptionDTO inscriptiondto){
 		Inscription inscription = new Inscription();
		BeanUtils.copyProperties(inscriptiondto, inscription);
		return inscription;
	}
	public InviteDTO fromInvite(Invite invite){
		InviteDTO invitedto = new InviteDTO();
		BeanUtils.copyProperties(invite, invitedto);
		return invitedto;
	}
	public Invite fromInviteDTO(InviteDTO invitedto){
 		Invite invite = new Invite();
		BeanUtils.copyProperties(invitedto, invite);
		return invite;
	}
	public SpeakerDTO fromSpeaker(Speaker speaker){
		SpeakerDTO speakerdto = new SpeakerDTO();
		BeanUtils.copyProperties(speaker, speakerdto);
		return speakerdto;
	}
	public Speaker fromSpeakerDTO(SpeakerDTO speakerdto){
 		Speaker speaker = new Speaker();
		BeanUtils.copyProperties(speakerdto, speaker);
		return speaker;
	}
	public ModerateurDTO fromModerateur(Moderateur moderateur){
		ModerateurDTO moderateurdto = new ModerateurDTO();
		BeanUtils.copyProperties(moderateur, moderateurdto);
		return moderateurdto;
	}
	public Moderateur fromModerateurDTO(ModerateurDTO moderateurdto){
 		Moderateur moderateur = new Moderateur();
		BeanUtils.copyProperties(moderateurdto, moderateur);
		return moderateur;
	}
	public ParticipantDTO fromParticipant(Participant participant){
		ParticipantDTO participantdto = new ParticipantDTO();
		BeanUtils.copyProperties(participant, participantdto);
		return participantdto;
	}
	public Participant fromParticipantDTO(ParticipantDTO participantdto){
 		Participant participant = new Participant();
		BeanUtils.copyProperties(participantdto, participant);
		return participant;
	}
	public SalleDTO fromSalle(Salle salle){
		SalleDTO salledto = new SalleDTO();
		BeanUtils.copyProperties(salle, salledto);
		return salledto;
	}
	public Salle fromSalleDTO(SalleDTO salledto){
 		Salle salle = new Salle();
		BeanUtils.copyProperties(salledto, salle);
		return salle;
	}
	public ConferenceDTO fromConference(Conference conference){
		ConferenceDTO conferencedto = new ConferenceDTO();
		BeanUtils.copyProperties(conference, conferencedto);
		return conferencedto;
	}
	public Conference fromConferenceDTO(ConferenceDTO conferencedto){
 		Conference conference = new Conference();
		BeanUtils.copyProperties(conferencedto, conference);
		return conference;
	}
	public SessionDTO fromSession(Session session){
		SessionDTO sessiondto = new SessionDTO();
		BeanUtils.copyProperties(session, sessiondto);
		return sessiondto;
	}
	public Session fromSessionDTO(SessionDTO sessiondto){
 		Session session = new Session();
		BeanUtils.copyProperties(sessiondto, session);
		return session;
	}
}