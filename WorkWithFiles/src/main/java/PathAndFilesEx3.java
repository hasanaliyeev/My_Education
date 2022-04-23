import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathAndFilesEx3 {

  public static void main(String[] args) throws IOException {

    Path filePath = Paths.get("data/test16.txt");
    String dialog = "-Hello\n-Hi\n-How are you?\n-I am fine";

    Files.write(filePath, dialog.getBytes());

    List<String> list = Files.readAllLines(filePath);
    list.forEach(System.out::println);


  }

}
