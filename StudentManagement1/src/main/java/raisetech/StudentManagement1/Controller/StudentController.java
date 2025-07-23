package raisetech.StudentManagement1.Controller;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement1.Application;
import raisetech.StudentManagement1.Data.Student;
import raisetech.StudentManagement1.Data.StudentsCourses;
import raisetech.StudentManagement1.Repository.StudentRepository;
import raisetech.StudentManagement1.Service.StudentService;

@RestController
public class StudentController {
  private StudentService service;

  @Autowired
  private StudentController(StudentService service){
    this.service = service;
  }

    @GetMapping("/studentList")                                      //2025/07/10追加
    public List<Student> getStudentList() {                      //2025/07/10追加
      return service.searchStudentList();                      //2025/07/10追加
    }

    @GetMapping("/studentsCourseList")
    public List<StudentsCourses> getStudentsCourseList() {
      return service.searchStudentsCourses();
    }
}
