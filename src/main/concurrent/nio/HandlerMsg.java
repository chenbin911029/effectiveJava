package main.concurrent.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by chenbin on 2019\8\22 0022.
 */
public class HandlerMsg implements Runnable {
    private Socket clientSocket;

    public HandlerMsg(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter os = new PrintWriter(clientSocket.getOutputStream(),true);
            //从InputStream当中读取客户端所发送的数据
            String inputLine = null;
            long b = System.currentTimeMillis();
            while ((inputLine = is.readLine()) != null) {
                os.println(inputLine);
            }
            long e = System.currentTimeMillis();
            System.out.println("spend:" + (e-b) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
