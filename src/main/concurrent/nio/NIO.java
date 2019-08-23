package main.concurrent.nio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenbin on 2019\8\22 0022.
 */
public class NIO {

    public static void nioCopyFile(String resource,String destination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            buffer.clear();
            int len = readChannel.read(buffer);
            if (len == -1) {
                //读取完毕
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }

        readChannel.close();
        writeChannel.close();
    }

    public void fileOperate() {
        try {
            RandomAccessFile raf = new RandomAccessFile("C:\\a.txt","rw");
            FileChannel fc = raf.getChannel();
            //将文件映射到内存中
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE,0,raf.length());
            while (mbb.hasRemaining()) {
                System.out.print((char)mbb.get());
            }
            mbb.put(0,(byte)98);
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String args[]) {
        ServerSocket echoServer = null;
        Socket clientSocket = null;
        try {
            echoServer = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                clientSocket = echoServer.accept();
                System.out.println(clientSocket.getRemoteSocketAddress() + "connect !");

                //使用线程池
                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(new HandlerMsg(clientSocket));
            } catch (IOException e) {}
        }
    }
}
