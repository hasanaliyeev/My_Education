import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FolderDeleteAndCopy {

  public static void main(String[] args) throws Exception {

    Path folder_A = Paths.get("C:/Users/aliye/Desktop/A");
    Path folder_B = Paths.get("C:/Users/aliye/Desktop/B");

    //delete("C:/Users/aliye/Desktop/OOO");
    copy("C:/Users/aliye/Desktop/X", "C:/Users/aliye/Desktop/Y");

  }

  public static void copy(String src, String dst) throws Exception {
    File file = new File(src);

    Path source = Paths.get(src);
    Path destination = Paths.get(dst);

    if (file.isFile()) {
      Path newDestination = destination.resolve(source.relativize(file.toPath()));
      Files.copy(source, newDestination,
          StandardCopyOption.REPLACE_EXISTING);
    }
    if (file.isDirectory()) {
      Path newDestination = destination.resolve(source.relativize(file.toPath()));
      Files.copy(source, newDestination,
          StandardCopyOption.REPLACE_EXISTING);
    }

    File[] folders = file.listFiles();
    if (folders != null) {
      for (File fl : folders) {
        if (fl.isFile()) {
          Path newDestination = destination.resolve(source.relativize(fl.toPath()));
          Files.copy(fl.toPath(), newDestination, StandardCopyOption.REPLACE_EXISTING);
        }
        if (fl.isDirectory()) {
          Path newDestination = destination.resolve(source.relativize(fl.toPath()));
          copy(fl.toString(), newDestination.toString());
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
