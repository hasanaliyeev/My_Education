import java.io.File;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  public static void main(String[] args) throws Exception {

    JFrame frame = new JFrame("File Encrypter");
    frame.setSize(600,400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    GUIForm form = new GUIForm();
    frame.add(form.getRootPanel());
    frame.setVisible(true);


  }


}
