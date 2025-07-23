package raisetech.StudentManagement1.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement1.Data.Student;
import raisetech.StudentManagement1.Data.StudentsCourses;
import raisetech.StudentManagement1.Repository.StudentRepository;

@Service
public class StudentService {
  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository){
    this.repository = repository;
  }
//  public List<Student>searchStudentList(){                                  //元ロジック　0723
//    return repository.search();                                             //元ロジック　0723
//  }                                                                         //元ロジック　0723
public List<Student> searchStudentList() {                                    //課題　　　　0723
  List<Student> allStudents = repository.search();                            //課題　　　　0723

  // 年齢が30以上かつ40未満（30代）だけを抽出                                        //課題　　　　0723
  return allStudents.stream()                                                 //課題　　　　0723
      .filter(student -> student.getAge() >= 20 && student.getAge() < 23)//課題　　　　0723
      .collect(Collectors.toList());                                          //課題　　　　0723
}                                                                             //課題　　　　0723
//  public List<StudentsCourses> searchStudentsCourses() {                    //元ロジック　0723
//     return repository.searchStudentsCourses();                             //元ロジック　0723
//  }                                                                         //元ロジック　0723
public List<StudentsCourses> searchStudentsCourses() {                        //課題　　　　0723
  List<StudentsCourses> allCourses = repository.searchStudentsCourses();      //課題　　　　0723

  // 「Java」という文字列が含まれるコースだけを抽出
  return allCourses.stream()                                                  //課題　　　　0723
      .filter(course -> course.getCourseName() != null && course.getCourseName().contains("Java"))
      .collect(Collectors.toList());                                          //課題　　　　0723
}                                                                             //課題　　　　0723
}
