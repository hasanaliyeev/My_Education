import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {

  public static void main(String[] args) throws IOException {

    Path filePath = Paths.get("data/testX.txt");
    Path directoryMPath = Paths.get("C:/Users/aliye/Desktop/M");
    Path directoryBPath = Paths.get("C:/Users/aliye/Desktop/B");

    if (!Files.exists(directoryMPath.resolve(filePath.getFileName()))) {
      Files.copy(filePath, directoryMPath.resolve(filePath.getFileName()));
      System.out.println("Done!");
    }
    System.out.println("--------------------------------------------------");

    if (!Files.exists(directoryMPath.resolve("testX2.txt"))) {
      Files.copy(filePath, directoryMPath.resolve("testX2.txt"));
      System.out.println("Done!");
    }
    System.out.println("--------------------------------------------------");

    Files.copy(filePath, directoryMPath.resolve(filePath.getFileName()),
        StandardCopyOption.REPLACE_EXISTING);
    System.out.println("Done!");
    System.out.println("--------------------------------------------------");

    Files.copy(directoryMPath, directoryBPath.resolve("M"), StandardCopyOption.REPLACE_EXISTING);
    System.out.println("--------------------------------------------------");

    Files.copy(directoryBPath, directoryMPath.resolve("B"), StandardCopyOption.REPLACE_EXISTING);
    System.out.println("--------------------------------------------------");

    Path path = Paths.get("data/test1.txt");
    if (Files.exists(path)) {
      Files.move(path, directoryBPath.resolve("test1.txt"));
      System.out.println("Done!");
    }
    System.out.println("--------------------------------------------------");

    Path path1 = Paths.get("test6.txt");
    Path path2 = Paths.get("data");

    if (Files.exists(path1)) {
      Files.move(path1, path2.resolve("test13.txt"));
      System.out.println("Done!");
    }
    System.out.println("--------------------------------------------------");

    if (Files.exists(Paths.get("data/test11_REN.txt"))) {
      Files.delete(Paths.get("data/test11_REN.txt"));
    }
    System.out.println("--------------------------------------------------");


    if (Files.exists(Paths.get("C:/Users/aliye/Desktop/I"))) {
      Files.delete(Paths.get("C:/Users/aliye/Desktop/I"));
      System.out.println("Done!");
    }


  }

}
