import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamsEx {

  public static void main(String[] args) {

    try (DataOutputStream outputStream = new DataOutputStream(
        new FileOutputStream("data/my_test.bin"));
        DataInputStream inputStream = new DataInputStream(new FileInputStream("data/my_test.bin"))
    ) {

      outputStream.writeBoolean(true);
      outputStream.writeByte(5);
      outputStream.writeChar(45);
      outputStream.writeDouble(45.7);

      System.out.println(inputStream.readBoolean());
      System.out.println(inputStream.readByte());
      System.out.println(inputStream.readChar());

    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}
