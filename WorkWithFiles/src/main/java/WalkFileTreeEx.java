import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeEx {

  public static void main(String[] args) throws IOException {

    String source = "C:/Users/aliye/Desktop/X";
    String destination = "C:/Users/aliye/Desktop/Y";

    //delete(source);
    //copy(source,destination);

    getFolderStructure(source);

  }

  public static void delete(String path) throws IOException {
    Path source = Paths.get(path);
    Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
      }
    });

  }

  public static void copy(String src, String dst) throws IOException {
    Path source = Paths.get(src);
    Path destination = Paths.get(dst);

    Files.walkFileTree(source, new SimpleFileVisitor<>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
          throws IOException {
        Path newDirectory = destination.resolve(source.relativize(dir));
        Files.copy(dir, newDirectory, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newDirectory = destination.resolve(source.relativize(file));
        Files.copy(file, newDirectory, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
      }

    });

  }

  public static void getFolderStructure(String path) throws IOException {
    Path source = Paths.get(path);

    Files.walkFileTree(source, new SimpleFileVisitor<>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
          throws IOException {
        System.out.println(
            "Folders:\t" + dir + "\n(Creation Time) - " + attrs.creationTime() + "\n");
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(
            "FILES:  \t" + file.getFileName() + "\n(Creation Time) - " + attrs.creationTime()
                + "\n");
        return FileVisitResult.CONTINUE;
      }

    });

  }



}
