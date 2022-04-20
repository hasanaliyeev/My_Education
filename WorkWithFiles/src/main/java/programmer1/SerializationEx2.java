package programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx2 {

  public static void main(String[] args) {
    Car car = new Car("Kia", "Rio");
    Employee employee = new Employee("Gasan", "Java Programist", 30, 60000, car);

    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        new FileOutputStream("data/employees2.bin"))) {

      outputStream.writeObject(employee);
      System.out.println("Done!");

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
