import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx2 {

  public static void main(String[] args) {

    try (RandomAccessFile file = new RandomAccessFile("data/test7.txt", "rw");
        FileChannel channel = file.getChannel();
    ) {

      String text = "I would spread the cloths under your feet:\n"
          + "But I, being poor, have only my dreams;\n"
          + "I have spread my dreams under your feet;\n"
          + "Tread softly because you tread on my dreams";

      ByteBuffer buffer = ByteBuffer.wrap(text.getBytes());
      channel.write(buffer);


    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
