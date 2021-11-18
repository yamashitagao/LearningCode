package learning.base.socket.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description
 * @author:Gjc
 * @time: 10:15
 * @date: 2021-10-12
 */


public class SocketTest {
    public static void main(String[] args) throws Exception {

        try (
                ServerSocket s = new ServerSocket(9090);
        ) {
            int i = 1;
            try  {

                while(true){
                    Socket incoming = s.accept();
                    System.out.println("Spawning"+ i);
                    Runnable runnable=new  ThreadedEchoHandler(incoming);
                    Thread thread = new Thread(runnable);
                    thread.start();
                    i++;

                }

            }catch (Exception e){

            }
        }catch (Exception e){

        }
    }
}
class ThreadedEchoHandler implements  Runnable{
    private Socket incoming;
    public ThreadedEchoHandler(Socket socket) {
        this.incoming = socket;
    }

    @Override
    public void run() {
        try(
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                ){

            try (Scanner scan = new Scanner(inputStream, "UTF-8")) {
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(outputStream, "UTF-8"),
                        true
                );
                out.println("hello!,Enter BYE to exit");

                boolean done = false;
                while (!done && scan.hasNextLine()) {
                    String line = scan.nextLine();
                    out.println("Echo:" + line);
                    if (line.trim().equals("BYE")) done = true;
                }
            }
        }catch (IOException e){

        }
    }
}

