import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class Main {

  public static void main(String[] args) {

    JFrame frame = new JFrame("File Encryptor");
    frame.setSize(600, 400);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    GUIForm form = new GUIForm();
    frame.add(form.getRootPanel());
    frame.setVisible(true);


  }

}


class Test {

  public static void main(String[] args) {
    ZipParameters parameters = new ZipParameters();
    parameters.setCompressionMethod(CompressionMethod.DEFLATE);
    parameters.setCompressionLevel(CompressionLevel.ULTRA);
    parameters.setEncryptFiles(true);
    parameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);

    String in = "C:/Users/aliye/Desktop/orange.jpeg";
    String out = new File(in).getParent() + "/" + "archive-enc.zip";
    File file = new File(in);

    ZipFile zipFile = new ZipFile(out);
    char[] pass = {'1', '2', '3', '4', '5'};
    zipFile.setPassword(pass);

    try {
      if (file.isDirectory()) {
        zipFile.addFolder(file, parameters);
      } else {
        zipFile.addFile(file, parameters);
      }
      System.out.println("Created Zip File");
    } catch (ZipException e) {
      e.printStackTrace();
    }

    try {
      System.out.println(new ZipFile("C:/Users/aliye/Desktop/archive-enc.zip").isEncrypted());
    } catch (ZipException e) {
      e.printStackTrace();
    }
  }
}
