package project.project1.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.project1.menu.entity.Account;
import project.project1.menu.entity.Student;
import project.project1.menu.repository.AccountRepository;
import project.project1.menu.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String add(Student student) {
        studentRepository.save(student);
        Account account = new Account();
        account.setUsername(student.getId());
        account.setPassword(passwordEncoder.encode(student.getBirth()+""));
        account.setRoles("ROLE_USER");
        accountRepository.save(account);
        return "Student Added Successfully";
    }

    public void delete(Student student) {
        studentRepository.delete(student);
        Account account = accountRepository.getByUsername(student.getId());
        accountRepository.delete(account);
    }

    public Student get(int id) {
        return studentRepository.findById(id);
    }
}
