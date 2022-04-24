

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FolderDelete {

  public static void main(String[] args) throws Exception {

    Path folder_A = Paths.get("C:/Users/aliye/Desktop/A");
    Path folder_B = Paths.get("C:/Users/aliye/Desktop/B");

    delete("C:/Users/aliye/Desktop/B");

  }

  public static void delete(String a) throws IOException {
    File file = new File(a);
    if (file.isFile()) {
      file.delete();
    }
    if (file.isDirectory()) {
      file.delete();
    }

    File[] folders = file.listFiles();
    if (folders != null) {
      for (File fl : folders) {
        if (fl.isFile()) {
          fl.delete();
        }
        if (fl.isDirectory()) {
          delete(fl.getAbsolutePath());
          fl.delete();
        }

      }
    }
    file.delete();

  }

}
