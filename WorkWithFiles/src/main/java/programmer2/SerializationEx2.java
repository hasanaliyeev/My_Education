package programmer2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import programmer1.Employee;

public class SerializationEx2 {

  public static void main(String[] args) {
    Employee bestEmployee;

    try (ObjectInputStream inputStream = new ObjectInputStream(
        new FileInputStream("data/employees2.bin"))) {

      bestEmployee = (Employee) inputStream.readObject();
      System.out.println(bestEmployee);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }

}
