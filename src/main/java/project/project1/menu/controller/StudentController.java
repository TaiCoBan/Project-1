package project.project1.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.project1.menu.entity.Student;
import project.project1.menu.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Student student = studentService.get(id);
        studentService.delete(student);
        return "Student Deleted Successfully";
    }
}
