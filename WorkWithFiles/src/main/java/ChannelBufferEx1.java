import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx1 {

  public static void main(String[] args) {

    try (RandomAccessFile file = new RandomAccessFile("data/test6.txt", "rw");
        FileChannel channel = file.getChannel()) {

      ByteBuffer buffer = ByteBuffer.allocate(25);
      StringBuilder builder = new StringBuilder();

      int byteRead = channel.read(buffer);
      while (byteRead > 0) {
                buffer.flip();

        while (buffer.hasRemaining()) {
          builder.append((char) buffer.get());
        }

        buffer.clear();
        byteRead = channel.read(buffer);
      }
      System.out.println(builder);

      String text = "\nАпельсин — плод апельсинового дерева (Citrus).\n"
          + "Сложно поверить, но исторически апельсин представляет собой гибрид мандарина\n"
          + "(Citrus ) и помело (Citrus maxima). Однако появился он так давно, что сейчас\n";

      ByteBuffer buffer1 = ByteBuffer.wrap(text.getBytes());
      channel.write(buffer1);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
