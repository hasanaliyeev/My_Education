import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

  public static final String DEST_PATH = "C:/Users/aliye/Desktop/X/";

  public static void main(String[] args) throws Exception {

    String htmlFile = parseFile("data/code.html");

    Document doc = Jsoup.parse(htmlFile);
    Document document = Jsoup.connect("https://lenta.ru/").get();

//    getImagePath(document).forEach(System.out::println);
    imageDownloader(document,DEST_PATH);

  }

  public static void imageDownloader(Document doc, String path) {

    List<String> paths = getImagePath(doc);

    for (int i = 0; i < paths.size(); i++) {
      String imageUrl = paths.get(i);
      String imageName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
      if (imageName.length() < 1 || Files.exists(Paths.get(imageName,path)) ) {
        continue;
      }
      try (InputStream in = new URL(imageUrl).openStream()) {
        Files.copy(in, Paths.get(path + imageName),
            StandardCopyOption.REPLACE_EXISTING);
        System.out.println(imageName);
      } catch (Exception e) {
        e.printStackTrace();
      }

    }

  }

  public static List<String> getImagePath(Document doc) {
    List<String> list = new ArrayList<>();
    Elements elements = doc.select("img");
    elements.forEach(element -> {
      String imageUrl = element.attr("abs:src");
      if (!list.contains(imageUrl)) {
        list.add(imageUrl);
      }
    });
    return list;
  }

  public static String parseFile(String path) {
    StringBuilder builder = new StringBuilder();

    try {
      List<String> lines = Files.readAllLines(Paths.get(path));
      builder.append(lines).append("\n");

    } catch (Exception e) {
      e.printStackTrace();
    }
    return builder.toString();

  }

}
