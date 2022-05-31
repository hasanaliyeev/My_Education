package JDBCExperiments;

import JDBCExperiments.core.Course;
import JDBCExperiments.core.CourseType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {

    String user = "root";
    String password = "Hasangunelalsu259";
    String url = "jdbc:mysql://localhost:3306/skillbox";

    Map<Integer,Course> courseMap = new HashMap<>();

    try (Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM courses")) {

      while (resultSet.next()){
        Course course = new Course();

        course.setId(resultSet.getInt("id"));
        course.setName(resultSet.getString("name"));
        course.setDuration(resultSet.getInt("duration"));
        course.setType(CourseType.valueOf(resultSet.getString("type")));
        course.setDescription(resultSet.getString("description"));
        course.setTeacherId(resultSet.getInt("teacher_id"));
        course.setStudentsCount(resultSet.getInt("students_count"));
        course.setPrice(resultSet.getInt("price"));
        course.setPricePerHour(resultSet.getFloat("price_per_hour"));

        courseMap.put(course.getId(),course);
      }

      courseMap.values().forEach(System.out::println);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
