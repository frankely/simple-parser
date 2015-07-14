import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile
                ("/Users/frankelydiaz/Desktop/codetest_files/input_files/comma.txt", "r");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(inChannel.read(buffer) > 0)
        {
            buffer.flip();
            for (int i = 0; i < buffer.limit(); i++)
            {
                System.out.print((char) buffer.get());
            }
            buffer.clear(); // do something with the data and clear/compact it.
        }
        inChannel.close();
        aFile.close();
    }
}
