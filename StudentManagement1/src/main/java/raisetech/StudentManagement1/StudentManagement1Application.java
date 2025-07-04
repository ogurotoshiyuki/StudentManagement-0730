package raisetech.StudentManagement1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagement1Application {

//	private String name = "Oguro　Toshiyuki";				//課題
//	private String age = "64";											//課題

	// ★ 蓄積用: List<Map>
	private List<Map<String, String>> students = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(StudentManagement1Application.class, args);
	}
	// GET: 全てのデータを返す
	@GetMapping("/studentInfo")
	public List<Map<String, String>> getStudentInfo() {
		return students;
//		return name + " " + age + "歳";							//課題
	}
	// POST: フォームデータを新しい Map にして List に追加
	@PostMapping("/studentInfo") //POST追加（name&age）
	public String setStudentInfo(
			@RequestParam String name,
			@RequestParam String age) {

		Map<String, String> student = new HashMap<>();
		student.put("name", name);
		student.put("age", age);

		students.add(student);

		System.out.println("追加された student: " + student);
		System.out.println("現在の students: " + students);

		return "Student added: " + student;// 画面にも返す
	}
//	public void setName(String name,String age){//課題
//		this.name = name;													//課題
//		this.age = age;														//課題
//	}																						//課題
//	@PostMapping("/studentName")//POST追加(name)	//課題
//	public void updateStudentName(String name){	//課題
//		this.name = name;													//課題
//	}																						//課題
//	@PostMapping("/studentAge")//POST追加(age)		//課題
//	public void updateStudentAge(String age){		//課題
//		this.age = age;														//課題
//	}																						//課題
}
