package raisetech.StudentManagement1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement1.controller.converter.StudentConverter;
import raisetech.StudentManagement1.data.Student;
import raisetech.StudentManagement1.data.StudentsCourses;
import raisetech.StudentManagement1.domain.StudentDetail;
import raisetech.StudentManagement1.service.StudentService;

@Controller
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping(value = "/studentList", produces = "application/json; charset=UTF-8")
  //2025/07/10追加
  public String getStudentList(Model model) {                      //2025/07/10追加
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentsCourses = service.searchStudentsCoursesList();
    model.addAttribute("studentList", converter.convertStudentDetails(students, studentsCourses));
    return "studentList";
  }

  @GetMapping("/studentsCoursesList")
  public String getStudentsCoursesList(Model model) {
    List<StudentsCourses> list = service.searchStudentsCoursesList();
    model.addAttribute("coursesList", list);
    return "studentsCoursesList"; // ← HTML名（拡張子は不要）
  }

  @GetMapping("/newStudent")
  public String newStudent(Model model) {
    model.addAttribute("studentDetail", new StudentDetail());
    return "registerStudent";
  }

  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
    if (result.hasErrors()) {
      return "registerStudent";
    }
    // studentの保存
    Student student = studentDetail.getStudent();
//    student.setId(UUID.randomUUID().toString()); // ID自動生成など必要ならここで設定
    service.insertStudent(student); // ← MySQLに保存

    // students_coursesの保存
    List<StudentsCourses> coursesList = studentDetail.getStudentsCoursesList();
    if (coursesList != null) {
      for (StudentsCourses course : coursesList) {
//        course.setId(UUID.randomUUID().toString());
        course.setStudentId(student.getId()); // 学生IDを設定
        service.insertStudentsCourses(course);
      }
    }
    System.out.println(
        studentDetail.getStudent().getName() + "さんが新規受講生として登録されました。");
    return "redirect:/studentList";
  }
}