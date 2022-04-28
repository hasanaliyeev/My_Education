import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCreation {

  public static void main(String[] args) {
    String in = "C:/Users/aliye/Desktop/image.jpeg";
    String out = "C:/Users/aliye/Desktop/archive.zip";

    try {
      FileOutputStream outputStream = new FileOutputStream(out);
      ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

      ZipEntry zipEntry = new ZipEntry(new File(in).getName());
      zipOutputStream.putNextEntry(zipEntry);

      byte[] data = Files.readAllBytes(Paths.get(in));
      zipOutputStream.write(data);
      zipOutputStream.flush();
      zipOutputStream.close();
      outputStream.close();
      System.out.println("Done!");

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

class ZipCreations{

  public static void main(String[] args) {
    String path = "C:/Users/aliye/Desktop/";

    String[] in = {"orange.jpeg", "file.txt", };
    String out = "C:/Users/aliye/Desktop/archive.zip";

    try {
      FileOutputStream outputStream = new FileOutputStream(out);
      ZipOutputStream zipOut = new ZipOutputStream(outputStream);

      for (String fileName : in) {
        File file = new File(path + fileName);
        ZipEntry entry = new ZipEntry(file.getName());
        zipOut.putNextEntry(entry);
        Path filePath = Paths.get(file.getAbsolutePath());
        byte[] data = Files.readAllBytes(filePath);
        zipOut.write(data);
      }
      zipOut.flush();
      zipOut.close();
      outputStream.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}