import java.io.File;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;


public class EncrypterThread extends Thread {

  private GUIForm form;
  private File file;
  private ZipParameters parameters;


  public EncrypterThread(GUIForm form) {
    this.form = form;
  }

  public void setFile(File file) {
    this.file = file;
  }

  @Override
  public void run() {
    onStart();
    try {
      parameters = ParametersContainer.getParameters();
      String archiveName = getArchiveName();
      ZipFile zipFile = new ZipFile(archiveName);
      char[] pass = {'1','2','3','4'};
      zipFile.setPassword(pass);

      if (file.isDirectory()) {
        zipFile.addFolder(file, parameters);
      } else {
        zipFile.addFile(file, parameters);
      }

    } catch (Exception e) {
      form.showWarning(e.getMessage());
    }
    onFinish();
  }

  private void onStart() {
    form.setButtonsEnabled(false);
  }

  private void onFinish() {
    form.setButtonsEnabled(true);
    form.showFinished();
  }

  private String getArchiveName() {
    for (int i = 1; ; i++) {
      String number = i > 1 ? Integer.toString(i) : "";
      String archiveName = file.getAbsolutePath().replaceAll("\\.[A-z]+$", "")
          + number + ".zip";
      if (!new File(archiveName).exists()) {
        return archiveName;
      }
    }
  }
}
