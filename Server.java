import java.io.*;
import java.net.*;

class Server 
{
    public static void main (String arg[]) throws Exception
    {
        System.out.println("-------------------------Chat Messenger-------------------");

        System.out.println("Server of Chat Messanger is running...");

        ServerSocket ssobj = new ServerSocket(2100);
        System.out.println("Server is in the listening mode at port no : 2100");

        Socket sobj = ssobj.accept();
        System.out.println("Client and server connection is successful"); 

        PrintStream ps = new PrintStream(sobj.getOutputStream());

        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("---------------------------------------------------------");

        System.out.println("Chat Messenger started...");

        System.out.println("---------------------------------------------------------");

        String str1, str2;

        while((str1 = br1.readLine()) != null)
        {
            System.out.println("Client says : " + str1);
            System.out.println("Enter message for client : ");
            str2 = br2.readLine();
            ps.println(str2);
        }

        System.out.println("Thank you for using Marvellous chat messanger...");

        sobj.close();
        ssobj.close();
        ps.close();
        br1.close();
        br2.close();

    }
}