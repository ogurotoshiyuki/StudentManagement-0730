package raisetech.StudentManagement1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagement1Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagement1Application.class, args);
	}
	@GetMapping("/hello")
	public String hello(){
		return "Hello,Word!";//コメント練習
	}
}
