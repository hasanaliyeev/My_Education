package programmer1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {

  public static void main(String[] args) {

    List<String> employees = new ArrayList<>();
    employees.add("Gasan");
    employees.add("Farid");
    employees.add("Alsu");

    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        new FileOutputStream("data/employees.txt"));

    ) {
      outputStream.writeObject(employees);
      System.out.println("Done!");

    } catch (IOException e) {
      e.printStackTrace();
    }


  }

}
