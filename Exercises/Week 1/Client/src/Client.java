import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client
{
    public static void main(String []args)
    {
        try
        {
            ServerSocket sk=new ServerSocket(8080);
            Socket client=sk.accept();
            DataOutputStream dos=new DataOutputStream(client.getOutputStream());
            DataInputStream dis=new DataInputStream(client.getInputStream());
            int []a={1,2,3,4,5};
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<a.length;i++)
                sb.append(a[i]+" ");
            dos.writeUTF(sb.toString());
            String s=dis.readUTF();
            String result[]=s.split(" ");
            System.out.println("Tổng là: " + result[0]);
            System.out.println("Tích là: " + result[1]);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}