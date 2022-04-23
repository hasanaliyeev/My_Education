import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class PathAndFilesEx1 {

  public static void main(String[] args) throws IOException {

    Path filePath = Paths.get("data/test12.txt");
    Path directoryPath = Paths.get("C:/Users/aliye/Desktop/from");
    Path anotherPath = Paths.get("C:/Users/aliye/Desktop/from/fol/dir/test20.txt");

    System.out.println(filePath.getFileName());
    System.out.println(directoryPath.getFileName());
    System.out.println("--------------------------");

    System.out.println(filePath.getParent());
    System.out.println(directoryPath.getParent());
    System.out.println("--------------------------");

    System.out.println(filePath.getRoot());
    System.out.println(directoryPath.getRoot());
    System.out.println("--------------------------");

    System.out.println(filePath.isAbsolute());
    System.out.println(directoryPath.isAbsolute());
    System.out.println("--------------------------");

    System.out.println(filePath.toAbsolutePath());
    System.out.println(directoryPath.toAbsolutePath());
    System.out.println("--------------------------");

    System.out.println(directoryPath.resolve(filePath));
    System.out.println("--------------------------");

    System.out.println(directoryPath.relativize(anotherPath));
    System.out.println("--------------------------");

    if (!Files.exists(filePath)) {
      Files.createFile(filePath);
    }

    if (!Files.exists(directoryPath)) {
      Files.createDirectory(directoryPath);
    }

    System.out.println(Files.isReadable(filePath));
    System.out.println(Files.isWritable(filePath));
    System.out.println(Files.isExecutable(filePath));
    System.out.println("--------------------------");

    System.out.println(Files.isReadable(directoryPath));
    System.out.println(Files.isReadable(directoryPath));
    System.out.println(Files.isExecutable(directoryPath));
    System.out.println("--------------------------");

    Path path1 = Paths.get("data/testX.txt");
    Path path2 = Paths.get("C:/Users/aliye/Desktop/Java/My_Education/WorkWithFiles/data/testX.txt");
    System.out.println(Files.isSameFile(path1, path2));
    System.out.println("--------------------------");

    System.out.println(Files.size(path1));
    System.out.println(Files.size(filePath));
    System.out.println("--------------------------");

    System.out.println(Files.getAttribute(filePath, "creationTime"));
    System.out.println(Files.getAttribute(filePath, "size"));
    System.out.println("--------------------------");

    Map<String, Object> atr = Files.readAttributes(filePath, "*");
    for (Map.Entry<String, Object> entry : atr.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }

  }

}
