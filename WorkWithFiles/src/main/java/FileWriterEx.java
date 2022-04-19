import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

  public static void main(String[] args) throws IOException {

    String text = "Апельсин — плод апельсинового дерева (Citrus).\n"
        + "Сложно поверить, но исторически апельсин представляет собой гибрид мандарина\n"
        + "(Citrus ) и помело (Citrus maxima). Однако появился он так давно, что сейчас\n"
        + "о его гибридном происхождении никто и не вспоминает: известен, что апельсины\n"
        + "культивировалось в Китае ещё за 2,5 тысячи лет до нашей эры.\n";

    FileWriter writer = null;
    try {
      writer = new FileWriter("data/test1.txt",true);
      for (int i = 0; i < text.length(); i++) {
        writer.write(text.charAt(i));
      }
      writer.write("Hello World");
      System.out.println("Done!");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      writer.close();
    }

  }

}
