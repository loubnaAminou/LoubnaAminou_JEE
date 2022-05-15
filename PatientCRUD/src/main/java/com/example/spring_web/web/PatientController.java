package com.example.spring_web.web;

import com.example.spring_web.entities.Patient;
import com.example.spring_web.repositories.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepo repo;

    @GetMapping("/index")
    public String patients(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword){
        //Page<Patient> patientsPage = repo.findAll(PageRequest.of(page, size));
        Page<Patient> patientsPage = repo.findByNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", patientsPage.getContent());
        model.addAttribute("pages", new int[patientsPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

     @GetMapping("/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "formPatient";

    }

    @PostMapping(path = "/save")
    public String save(Model model, @Valid Patient patient, BindingResult result,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if (result.hasErrors()) return "formPatient";
        repo.save(patient);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/edit")
    public String edit(Model model, Long id,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        Patient patient = repo.findById(id).orElse(null);
        if(patient == null) throw new RuntimeException("Unavailable patient !!!");
        model.addAttribute("patient", patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editPatient";//?page=+page+"&keyword="+keyword
    }

    @GetMapping("/delete")
    public String delete(Long id, int page){
        repo.deleteById(id);
        return "redirect:/index?page="+page;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> patients(){
        return repo.findAll();
    }
}
