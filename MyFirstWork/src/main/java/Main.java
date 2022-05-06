import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  public static void main(String[] args) throws Exception {

    String path = "data/salary.csv";

    List<String> line = Files.readAllLines(Paths.get(path));
    StringBuilder builder = new StringBuilder();
    int sum = 0;
    for(int i = 0; i < line.size(); i++){
      String[] str = line.get(i).split(";");
      sum+= Integer.parseInt(str[2]);
    }
    System.out.println(builder);
    System.out.println(sum);

  }

}
