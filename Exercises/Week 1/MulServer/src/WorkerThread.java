import java.io.*;
import java.net.Socket;

public class WorkerThread extends Thread {
    private Socket socket;

    public WorkerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("Processing: " + socket);
        try {
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            DataInputStream dis=new DataInputStream(socket.getInputStream());
            String s=dis.readUTF();
            String str[]=s.split(" ");
            int tong = 0;
            int tich = 1;
            for(int i=0;i<str.length;i++) {
                tong += Integer.parseInt(str[i]);
                tich *= Integer.parseInt(str[i]);
            }
            dos.writeUTF(tong + " " + tich);
        } catch (IOException e) {
            System.err.println("Request Processing Error: " + e);
        }
        System.out.println("Complete processing: " + socket);
    }
}