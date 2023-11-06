import java.io.*;
class filedemo
{
public static void p(String str)
{
    System.out.println(str);
 }
 public static void analyze(String s)
{
File f=new File(s);
 if(f.exists())
 {
 p(f.getName()+" is a file");
 p(f.canRead()?" is readable":" is not readable");
 p(f.canWrite()?" is writable":" is not writable");
 p("Filesize:"+f.length()+" bytes");
 p("File last mdified:"+f.lastModified());
 }
 if(f.isDirectory())
 {
 p(f.getName()+" is directory");
 p("List of files");
 String dir[]=f.list();
 for(int i=0;i<dir.length;i++)
 p(dir[i]);
 }
 }

}
public class FileDetails
{
 public static void main(String rr[])throws IOException
 {
 filedemo fd=new filedemo();
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 System.out.println("Enter the file name:");
 String s=br.readLine();
 fd.analyze(s);
 }
}

import java.io.*;

public class BinaryFileDemo {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("data.bin");
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeInt(100);
            dos.writeDouble(3.14);
            dos.writeBoolean(true);
            dos.writeUTF("Hello");
            System.out.println("Data written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read the data from the file
        try (FileInputStream fis = new FileInputStream("data.bin");
             DataInputStream dis = new DataInputStream(fis)) {
            int i = dis.readInt();
            double d = dis.readDouble();
            boolean b = dis.readBoolean();
            String s = dis.readUTF();
            System.out.println("Data read from the file:");
            System.out.println("i = " + i);
            System.out.println("d = " + d);
            System.out.println("b = " + b);
            System.out.println("s = " + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
