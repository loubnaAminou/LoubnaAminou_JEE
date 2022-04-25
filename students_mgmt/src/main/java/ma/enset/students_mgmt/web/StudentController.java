package ma.enset.students_mgmt.web;

import lombok.AllArgsConstructor;
import ma.enset.students_mgmt.entities.Student;
import ma.enset.students_mgmt.repositories.StudentRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentRepo studentRepo;

    @GetMapping("/")
    public String index(){
        return "home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/students")
    public String students(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword
                           ){

           Page<Student> students = studentRepo.findStudentByLastnameContains(keyword, PageRequest.of(page, size));
            model.addAttribute("students", students);
            model.addAttribute("total", new int [students.getTotalPages()]);
            model.addAttribute("current", page);
            model.addAttribute("keyword", keyword);

        return "students";
    }

    @GetMapping("/new_student")
    public String newStudent(Model model){
        model.addAttribute("student", new Student());
        return "form_student";
    }

    @PostMapping("save_student")
    public String save(Model model, @Valid Student student, String id,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        System.out.println("############" +id.isEmpty());
        if (id.isEmpty()){
            System.out.println("***************NULL ID**********************");
            student.setId(UUID.randomUUID().toString());
        }else student.setId(id);
        studentRepo.save(student);
        return "redirect:/students?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/edit_student")
    public String edit(Model model, String id,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword) {
        Student student = studentRepo.findById(id).orElse(null);
        model.addAttribute("student", student);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "form_student";
    }

    @GetMapping("/delete_student/{id}")
    public String delete(@PathVariable String id){
        System.out.println(studentRepo.findById(id));
        studentRepo.deleteById(id);
        return "redirect:/students";
    }
}
