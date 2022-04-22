import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferEx4 {

  public static void main(String[] args) {

    try(RandomAccessFile file = new RandomAccessFile("data/test9.txt","r");
        FileChannel channel = file.getChannel();
    ) {
      ByteBuffer buffer = ByteBuffer.allocate(5);
      channel.read(buffer);
      buffer.flip();

      System.out.println((char) buffer.get());//a
      System.out.println((char) buffer.get());//b
      System.out.println((char) buffer.get());//c
      buffer.rewind();
      System.out.println((char) buffer.get());//a
      System.out.println("-----------------------------");

      buffer.compact();
      channel.read(buffer);
      buffer.flip();
      while (buffer.hasRemaining()){
        System.out.println((char) buffer.get());
      }
      System.out.println("-----------------------------");

      buffer.clear();
      channel.read(buffer);
      buffer.flip();
      System.out.println((char) buffer.get());//g
      buffer.mark();
      System.out.println((char) buffer.get());//h
      System.out.println((char) buffer.get());//i
      buffer.reset();
      System.out.println();
      while (buffer.hasRemaining()){
        System.out.println((char) buffer.get());
      }


    } catch (IOException e){
      e.printStackTrace();
    }

  }

}
