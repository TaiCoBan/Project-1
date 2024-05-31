package project.project1.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.project1.menu.entity.Student;
import project.project1.menu.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/add-student-form")
    public String add() {
        return "add-student-form";
    }

    @PostMapping("/add-student")
    public String add(Student student) {
        studentService.add(student);
        return "redirect:/students/all-students";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        Student student = studentService.get(id);
        studentService.delete(student);
        return "redirect:/students/all-students";
    }

    @GetMapping("/all-students")
    public String showAllStudents(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "all-students";
    }

    @GetMapping("/update-student-form")
    public String update(@RequestParam("id") int id, Model model) {
        Student student = studentService.get(id);
        model.addAttribute("student", student);
        return "update-student-form";
    }

    @PostMapping("/update-student")
    public String submit(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:/students/all-students";
    }
}
