import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyEx {

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new FileReader("data/test2.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("data/test3.txt", true))
    ) {
      String line;
      while ((line = reader.readLine()) != null) {
        writer.write(line + "\n");
      }

    } catch (IOException e) {
      e.printStackTrace();
    }


  }

}
