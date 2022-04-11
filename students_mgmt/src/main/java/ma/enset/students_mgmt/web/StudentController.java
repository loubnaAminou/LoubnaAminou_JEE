package ma.enset.students_mgmt.web;

import lombok.AllArgsConstructor;
import ma.enset.students_mgmt.entities.Student;
import ma.enset.students_mgmt.repositories.StudentRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentRepo studentRepo;

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

    @DeleteMapping("/delete_student/{id}")
    public String delete(@PathVariable("id") String id){
        System.out.println(id);
        studentRepo.deleteById(id);
        return "redirect:students";
    }
}
