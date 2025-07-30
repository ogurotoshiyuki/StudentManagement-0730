package raisetech.StudentManagement1.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement1.data.Student;
import raisetech.StudentManagement1.data.StudentsCourses;
import raisetech.StudentManagement1.repository.StudentRepository;

@Service
public class StudentService {
  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository){
    this.repository = repository;
  }
  public List<Student>searchStudentList(){                                  //元ロジック　0723
    return repository.search();                                             //元ロジック　0723
  }                                                                         //元ロジック　0723

  public List<StudentsCourses> searchStudentsCoursesList() {                    //元ロジック　0723
     return repository.searchStudentsCourses();                             //元ロジック　0723
  }

  public void registerStudent(Student student) {
//    student.setId(UUID.randomUUID().toString());
    repository.insertStudent(student);
  }

  public void insertStudent(Student student) {
    repository.insertStudent(student);
  }
  public void insertStudentsCourses(StudentsCourses course) {
    repository.insertStudentsCourses(course);
  }
}
