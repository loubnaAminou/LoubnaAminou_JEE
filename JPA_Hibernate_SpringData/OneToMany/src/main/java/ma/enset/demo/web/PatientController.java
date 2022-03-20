package ma.enset.demo.web;

import ma.enset.demo.entities.Patient;
import ma.enset.demo.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PatientController {
    @Autowired
    private PatientRepo patientRepo;
    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRepo.findAll();
    }
}
