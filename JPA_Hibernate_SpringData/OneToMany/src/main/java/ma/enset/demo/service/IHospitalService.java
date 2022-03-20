package ma.enset.demo.service;

import ma.enset.demo.entities.Consultation;
import ma.enset.demo.entities.Medecin;
import ma.enset.demo.entities.Patient;
import ma.enset.demo.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
