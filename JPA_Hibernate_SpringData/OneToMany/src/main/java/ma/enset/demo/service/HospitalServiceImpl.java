package ma.enset.demo.service;

import ma.enset.demo.entities.Consultation;
import ma.enset.demo.entities.Medecin;
import ma.enset.demo.entities.Patient;
import ma.enset.demo.entities.RendezVous;
import ma.enset.demo.repositories.ConsultationRepo;
import ma.enset.demo.repositories.MedecinRepo;
import ma.enset.demo.repositories.PatientRepo;
import ma.enset.demo.repositories.RendezVousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepo patientRepo;
    private MedecinRepo medecinRepo;
    private RendezVousRepo rendezVousRepo;
    private ConsultationRepo consultationRepo;

    public HospitalServiceImpl(PatientRepo patientRepo, MedecinRepo medecinRepo, RendezVousRepo rendezVousRepo, ConsultationRepo consultationRepo) {
        this.patientRepo = patientRepo;
        this.medecinRepo = medecinRepo;
        this.rendezVousRepo = rendezVousRepo;
        this.consultationRepo = consultationRepo;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepo.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepo.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepo.save(consultation);
    }
}
