import java.io.File;
import net.lingala.zip4j.ZipFile;

public class DecrypterThread extends Thread{

  private GUIForm form;
  private File file;
  private String password;

  public DecrypterThread (GUIForm form){
    this.form = form;
  }

  public void setFile(File file) {
    this.file = file;
  }

  @Override
  public void run() {
    onStart();
    try {
      String outPath = getOutputPath();
      ZipFile zipFile = new ZipFile(file);
      zipFile.extractAll(outPath);
    } catch (Exception e) {
      form.showWarning(e.getMessage());
    }
    onFinish();
  }

  private void onStart(){
    form.setButtonsEnabled(false);
  }

  private void onFinish(){
    form.setButtonsEnabled(true);
    form.showFinished();
  }

  private String getOutputPath() {
    for (int i = 1; ; i++) {
      String number = i > 1 ? Integer.toString(i) : "";
      String path = file.getAbsolutePath().replaceAll("\\.zip$", "") + number;
      if (!new File(path).exists()) {
        return path;
      }
    }
  }
}
