package programmer2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {

  public static void main(String[] args) {

    List<String> employees;

    try (ObjectInputStream inputStream = new ObjectInputStream(
        new FileInputStream("data/employees.bin"))) {

      employees = (ArrayList) inputStream.readObject();
      System.out.println(employees);


    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
