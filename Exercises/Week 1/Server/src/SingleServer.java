import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleServer
{
    public static void main(String []args)
    {
        try
        {
            System.out.println("Server already!");
            ServerSocket sk=new ServerSocket(8080);
            Socket server=sk.accept();
            DataOutputStream dos=new DataOutputStream(server.getOutputStream());
            DataInputStream dis=new DataInputStream(server.getInputStream());
            String s=dis.readUTF();
            String str[]=s.split(" ");
            int tong = 0;
            int tich = 1;
            for(int i=0;i<str.length;i++) {
                tong += Integer.parseInt(str[i]);
                tich *= Integer.parseInt(str[i]);
            }
            dos.writeUTF(tong + " " + tich);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}