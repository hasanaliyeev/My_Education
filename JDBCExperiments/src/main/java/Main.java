import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    String user = "root";
    String password = "Hasangunelalsu259";
    String url = "jdbc:mysql://localhost:3306/skillbox";

    try(Connection connection = DriverManager.getConnection(url,user,password)) {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT \n"
          + "course_name,\n"
          + "COUNT(*) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) `avr_crs`\n"
          + "FROM purchaselist\n"
          + "GROUP BY course_name");

      while (resultSet.next()){
        System.out.println(resultSet.getString("course_name"));
      }

    } catch (Exception e){
      e.printStackTrace();
    }

  }

}
