import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx3 {

  public static void main(String[] args) {

    try(FileOutputStream outputStream = new FileOutputStream("data/test8.txt");
        FileChannel channel = outputStream.getChannel();
    ) {

      String text = "My name is Gasan Aliev.\n"
          + "I live in Russia";

      ByteBuffer buffer = ByteBuffer.wrap(text.getBytes());
      channel.write(buffer);


    } catch (IOException e){
      e.printStackTrace();
    }

  }

}
