package CodeFiles;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Decompress {

    public static void method(File file) throws FileNotFoundException, IOException {
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);

        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzipIs = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DeCompressedFile.txt");

        byte[] buffer = new byte[1024];
        int len;
        while((len=gzipIs.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzipIs.close();
        fis.close();
        fos.close();


    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File path = new File("C:/Users/dhiva/IdeaProjects/CompressDecompress/CompressedFile.gz");
        method(path);
    }
}
