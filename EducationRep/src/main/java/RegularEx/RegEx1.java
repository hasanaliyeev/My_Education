package RegularEx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx1 {

  public static final String PATH = "src/main/resources/reg.txt";

  public static void main(String[] args) {

    String text = getFile();

    Pattern pattern = Pattern.compile("[\\d]+");
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()){
      System.out.println(matcher.group());
    }
  }

  public static String getFile() {
    StringBuilder builder = new StringBuilder();
    try {
      List<String> lines = Files.readAllLines(Paths.get(PATH));
      lines.forEach(line -> builder.append(line).append("\n"));

    } catch (IOException e) {
      e.printStackTrace();
    }
    return builder.toString();
  }

}
