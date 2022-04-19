import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx  {

  public static void main(String[] args) throws IOException {
    FileReader reader = null;
    try {
      reader = new FileReader("data/test2.txt");
      int character;
      while ((character = reader.read())!=-1){
        System.out.print((char) character);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      reader.close();
    }

  }

}
