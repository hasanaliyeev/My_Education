import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

  public static void main(String[] args) throws Exception {

    Document document = Jsoup.connect("https://lenta.ru/").get();
    Elements elements = document.select("img");
    elements.forEach(element -> {

      String index = element.attr("abs:src");
      System.out.println(element);
    });


  }
}
