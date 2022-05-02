import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

  public static void main(String[] args) {

    String in = "C:/Users/aliye/Desktop/archive.zip";
    String out = "C:/Users/aliye/Desktop/result/";

    try {
      //Extracting archive
      FileInputStream inputStream = new FileInputStream(in);
      ZipInputStream zipInput = new ZipInputStream(inputStream);

      while (true) {
        ZipEntry entry = zipInput.getNextEntry();
        if (entry == null) {
          break;
        }

        File file = new File(out + entry.getName());
        if (file.isDirectory()) {
          file.mkdirs();
        } else {
          file.createNewFile();
        }
      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void writeFileToZip(File file, ZipOutputStream zipOut, String path)
      throws Exception {

    if (file.isDirectory()) {
      String folder = path + file.getName() + "/";
      ZipEntry entry = new ZipEntry(folder);
      zipOut.putNextEntry(entry);
      zipOut.closeEntry();
      File[] files = file.listFiles();
      for (File subfile : files) {
        writeFileToZip(subfile, zipOut, folder);
      }
      return;
    }
    ZipEntry entry = new ZipEntry(path + file.getName());
    zipOut.putNextEntry(entry);
    byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    zipOut.write(bytes);

  }

}
