import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.lingala.zip4j.ZipFile;

public class Decrypter {

  ZipFile zipFile;
  File file;

  public void setFile(File file) {
    this.file = file;
  }

  public void fileDecrypt() {
    zipFile = new ZipFile(file);
    try {
      zipFile.extractAll(new File(getFileName()).getParent());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getFileName() {

    for (int i = 1; ; i++) {
      String number = i > 1 ? Integer.toString(i) : "";
      String path = file.getAbsolutePath().replaceAll("\\.zip$", "") + number;
      if(!Files.exists(Paths.get(path))){
        return path;
      }
    }

  }

  public static void main(String[] args) {

    Decrypter decrypter = new Decrypter();
    decrypter.setFile(new File("C:/Users/aliye/Desktop/folder.zip"));
    decrypter.fileDecrypt();

  }
}
