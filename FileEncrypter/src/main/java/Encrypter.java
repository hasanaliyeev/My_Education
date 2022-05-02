import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.lingala.zip4j.ZipFile;

public class Encrypter {

  ZipFile zipFile;
  File file;

  public void setFile(File file) {
    this.file = file;
  }

  public void fileEncrypt() {
    zipFile = new ZipFile(getArchiveName());
    try {
      if (file.isDirectory()) {
        zipFile.addFolder(file);
      } else {
        zipFile.addFile(file);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private String getArchiveName() {
    for (int i = 1; ; i++) {
      String number = i > 1 ? Integer.toString(i) : "";
      String path = file.getAbsolutePath().replaceAll("\\.[A-z]+$", "") + number + ".zip";
      if(!Files.exists(Paths.get(path))){
        return path;
      }
    }

  }

}
