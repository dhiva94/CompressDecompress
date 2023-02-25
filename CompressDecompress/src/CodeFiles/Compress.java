package CodeFiles;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Compress {
    public static void method(File file) throws FileNotFoundException, IOException {
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz");
        GZIPOutputStream gzipOs = new GZIPOutputStream(fos);

        byte[] buffer = new byte[3];
        int len;
        while((len=fis.read(buffer))!=-1){
            gzipOs.write(buffer,0,len);
        }
        fis.close();
        gzipOs.close();
        fos.close();

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File path = new File("C:/Users/dhiva/IdeaProjects/CompressDecompress/Testfile.txt");
        method(path);
    }
}
