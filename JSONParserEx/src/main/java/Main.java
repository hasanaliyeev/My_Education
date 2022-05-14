
public class Main {

  public static final String DATA_FILE = "data/map.json";
  public static final String CONNECTION_URL = "https://skillbox-java.github.io/";

  public static void main(String[] args) throws Exception {

    JSONSimpleParser parser = new JSONSimpleParser();
    Root root = parser.parse();
    //root.printLineInfo();
    System.out.println(root.getLines());

  }

}