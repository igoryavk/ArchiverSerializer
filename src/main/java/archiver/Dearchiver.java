package archiver;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Dearchiver {
    private Archive archive;
    private ObjectInputStream objectInputStream;
    private FileOutputStream outputStream;

    public Dearchiver(String filename) { try {

        objectInputStream=new ObjectInputStream(new FileInputStream(filename));
        archive=(Archive) objectInputStream.readObject();

    } catch (IOException | ClassNotFoundException exception) {
        exception.printStackTrace();
    }
        DeserializeData();
    }

    public void DeserializeData(){

        archive.getItemList().stream().forEach(item -> {
            try {
                outputStream=new FileOutputStream(item.getName());
                outputStream.write(item.getBuffer());
                outputStream.close();
                System.out.println("Data dearchived");
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }


}
