package raisetech.StudentManagement1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagement1Application {

		@Autowired																			//2025/07/09追加
		private StudentRepository repository;						//2025/07/09追加

	public static void main(String[] args) {
		SpringApplication.run(StudentManagement1Application.class, args);
	}
	// GET: 全てのデータを返す
	@GetMapping("/student")
			public String getStudentInfo(@RequestParam String name){	//2025/07/09追加
			Student student= repository.searchByName(name);						//2025/07/09追加
//	public List<Map<String, String>> getStudentInfo() {					//2025/07/09削除
		return student.getName()+" " + student.getAge() + "歳";			//2025/07/09追加
	}
	// POST: フォームデータを新しい Map にして List に追加
	@PostMapping("/student")
	public void registerStudent(String name,int age){
		repository.registerStudent(name,age);
	}

	@PatchMapping("/student")																		//2025/07/09追加
	public void updateStudentName(String name,int age){					//2025/07/09追加
		repository.updateStudent(name,age);												//2025/07/09追加
	}

	@DeleteMapping("/student")																	//2025/07/09追加
	public void deleteStudent(String name){											//2025/07/09追加
		repository.deleteStudent(name);														//2025/07/09追加
	};
}
