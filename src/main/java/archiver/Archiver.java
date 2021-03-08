package archiver;

import java.io.*;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver {

    private Archive archive;
    private File FileInfo;
    private FileInputStream inputStream;
    private byte[] buffer;
    private ObjectOutputStream objectOutputStream;

    public Archiver(String[] filenames) {
        archive=new Archive();
        Arrays.stream(filenames).forEach(filename->{
            try {
                Item item = new Item();
                FileInfo = new File(filename);
                if (FileInfo.exists() )
                {
                    if (FileInfo.isFile()) {


                        item.setName(FileInfo.getName());


                        inputStream = new FileInputStream(filename);
                        buffer = new byte[inputStream.available()];
                        inputStream.read(buffer);
                        inputStream.close();
                        item.setBuffer(buffer);

                        archive.addItem(item);
                    } else {
                        System.out.println("Check file name: " + filename);
                    }
                }
                else
                {
                    System.out.println("File doesn't exsist -"+filename);
                }


            } catch (IOException e) {
                e.getMessage();
            }

        });
        if (archive.getItemsNumber()!=0)
        {
            SerializeData();
        }

    }

    private void SerializeData(){
        try {
            objectOutputStream =new ObjectOutputStream(new FileOutputStream("output.arch"));
            objectOutputStream.writeObject(archive);
            objectOutputStream.close();
            System.out.println("Archive saved");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}
