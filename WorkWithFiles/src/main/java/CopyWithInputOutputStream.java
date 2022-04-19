import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyWithInputOutputStream {

  public static void main(String[] args) {

    try (FileInputStream inputStream = new FileInputStream("C:/Users/aliye/Desktop/orange.jpg");
        FileOutputStream outputStream = new FileOutputStream("data/orange.jpg")
    ) {
      int i;
      while ((i = inputStream.read()) != -1) {
        outputStream.write(i);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
