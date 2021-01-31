import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client2
{
    public static void main(String []args)
    {
        try
        {
            Socket client2=new Socket("localhost",8081);
            DataOutputStream dos=new DataOutputStream(client2.getOutputStream());
            DataInputStream dis=new DataInputStream(client2.getInputStream());
            int []a={1,2,3,4,5,6};
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