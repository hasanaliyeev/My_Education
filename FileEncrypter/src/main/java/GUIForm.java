import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Locale;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;

public class GUIForm {

  private JPanel rootPanel;
  private JButton selectButton;
  private JTextField filePath;
  private JButton actionButton;
  private JRadioButton radioButton1;
  private JPasswordField passwordField1;
  private JSpinner spinner1;
  private File selectedFile;

  public GUIForm(){

    radioButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        actionButton.setVisible(false);
      }
    });
    selectButton.addActionListener(new Action() {
      @Override
      public Object getValue(String key) {
        return null;
      }

      @Override
      public void putValue(String key, Object value) {

      }

      @Override
      public void setEnabled(boolean b) {

      }

      @Override
      public boolean isEnabled() {
        return false;
      }

      @Override
      public void addPropertyChangeListener(PropertyChangeListener listener) {

      }

      @Override
      public void removePropertyChangeListener(PropertyChangeListener listener) {

      }

      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(rootPanel);
        selectedFile = chooser.getSelectedFile();
        if(selectedFile == null){
          filePath.setText("");
          return;
        }
        filePath.setText(selectedFile.getAbsolutePath());
      }
    });

    actionButton.addActionListener(new Action() {
      @Override
      public Object getValue(String key) {
        return null;
      }

      @Override
      public void putValue(String key, Object value) {

      }

      @Override
      public void setEnabled(boolean b) {

      }

      @Override
      public boolean isEnabled() {
        return false;
      }

      @Override
      public void addPropertyChangeListener(PropertyChangeListener listener) {

      }

      @Override
      public void removePropertyChangeListener(PropertyChangeListener listener) {

      }

      @Override
      public void actionPerformed(ActionEvent e) {
        Encrypter encrypter = new Encrypter();
        encrypter.setFile(selectedFile);
        encrypter.fileEncrypt();
      }
    });
  }

  public JPanel getRootPanel() {
    return rootPanel;
  }
}
