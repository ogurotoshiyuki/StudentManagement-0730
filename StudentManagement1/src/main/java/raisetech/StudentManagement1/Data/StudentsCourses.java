package raisetech.StudentManagement1.Data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

  @Getter
  @Setter
  public class StudentsCourses {

    private String id;
    private String studentId;
    private String courseName;
    private LocalDateTime courseStartAt;
    private LocalDateTime courseEndAt;
  }

