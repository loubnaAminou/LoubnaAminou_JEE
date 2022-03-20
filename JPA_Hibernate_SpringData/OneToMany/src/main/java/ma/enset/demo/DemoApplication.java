package ma.enset.demo;

import ma.enset.demo.entities.*;
import ma.enset.demo.repositories.ConsultationRepo;
import ma.enset.demo.repositories.MedecinRepo;
import ma.enset.demo.repositories.PatientRepo;
import ma.enset.demo.repositories.RendezVousRepo;
import ma.enset.demo.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Bean : méthode qui s'exécute au démmarage. Objet : Spring  component
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepo patientRepo,
                            MedecinRepo medecinRepo,
                            RendezVousRepo rendezVousRepo,
                            ConsultationRepo consultationRepo){
        return args -> {
            /**************     Patients    **************/
            hospitalService.savePatient(new Patient(null,"Lou", new Date(),false,null));
            Stream.of("Mery", "Latifa", "medAmine").forEach(name -> {
                Patient p = new Patient();
                p.setNom(name);
                p.setDateNaissance(new Date());
                p.setMalade(false);
                hospitalService.savePatient(p);
            });

            /*****************      Medecins    *******************/
            Stream.of("Fatima", "Jamaa", "Ahmed").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setName(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Psycho");
                hospitalService.saveMedecin(medecin);
            });

            /***************    RendezVous    *****************/
            Patient patient = patientRepo.findByNom("Lou");
            Medecin medecin = medecinRepo.findById(2L).orElse(null);

            RendezVous rdv = new RendezVous();
            rdv.setDate(new Date());
            rdv.setStatus(StatusRDV.DONE);
            rdv.setPatient(patient);
            rdv.setMedecin(medecin);
            hospitalService.saveRDV(rdv);

            /***************      Consultation      *****************/
            RendezVous rendezVous = rendezVousRepo.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsult(rendezVous.getDate());
            consultation.setRendezVous(rendezVous);
            consultation.setRapportConsult("Rapport de la consultation N° ...");
            hospitalService.saveConsultation(consultation);


        };
    }

}
