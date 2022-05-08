import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

  public static void main(String[] args) {

    String htmlFile = parseFile("data/code.html");
    Document doc = Jsoup.parse(htmlFile);
    Elements elements = doc.select("li.tabs-list__item");
    elements.forEach(element -> System.out.println(element.text()));

  }

  public static String parseFile(String path) {
    StringBuilder builder = new StringBuilder();

    try {
      List<String> lines = Files.readAllLines(Paths.get(path));
      lines.forEach(line -> builder.append(line + "\n"));


    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return builder.toString();
  }
}
