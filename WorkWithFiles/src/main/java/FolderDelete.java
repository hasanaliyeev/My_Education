import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FolderDelete {

  public static void main(String[] args) throws Exception {

    Path folder_A = Paths.get("C:/Users/aliye/Desktop/A");
    Path folder_B = Paths.get("C:/Users/aliye/Desktop/B");

    //delete("C:/Users/aliye/Desktop/E");
    copy("C:/Users/aliye/Desktop/Programs", "C:/Users/aliye/Desktop/E");

  }

  public static void copy(String a, String b) throws Exception {
    File file = new File(a);

    Path from = Paths.get(a);
    Path to = Paths.get(b);

    if (file.isFile()) {
      Files.copy(from, to.resolve(from.getFileName()), StandardCopyOption.REPLACE_EXISTING);

    }
    if (file.isDirectory()) {
      Files.copy(from, to.resolve(from.getFileName()), StandardCopyOption.REPLACE_EXISTING);

    }

    File[] folders = file.listFiles();
    if (folders != null) {
      for (File fl : folders) {
        if (fl.isFile()) {
          copy(fl.getAbsolutePath(), to.resolve(fl.toPath().getParent().getFileName()).toString());
        }
        if (fl.isDirectory()) {
          copy(fl.getAbsolutePath(), to.resolve(fl.toPath().getParent().getFileName()).toString());
        }

      }
    }

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
