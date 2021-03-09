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
//        Для каждого переданного имени файлов получаем
//        информацию и передаем
        Arrays.stream(filenames).forEach(filename->{
            try {
//                Создаем элемент
                Item item = new Item();
//                Сначала получим информацию о файле
                FileInfo = new File(filename);
//                Проверим существует он или нет
                if (FileInfo.exists() )
                {
//                    И файл ли это
                    if (FileInfo.isFile()) {

//                        Если все нормально, то сохраняем в элементе имя файла
                        item.setName(FileInfo.getName());

//                        Создаем входной поток для файла
                        inputStream = new FileInputStream(filename);
//                        Создаем байтовый массив в качестве буфера
                        buffer = new byte[inputStream.available()];
//                        Записываем данные из файла в буфер
                        inputStream.read(buffer);
//                        Закрываем поток
                        inputStream.close();
//                        Сохраняем данные о файле в элементе
                        item.setBuffer(buffer);
//                        Добавляем элемент внутрь объекта архива, хранящего коллекцию
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
//            Данный метод сериализует коллекцию
            SerializeData();
        }

    }

    private void SerializeData(){
        try {
//            Создаем поток для записи коллеции во внешний файл
            objectOutputStream =new ObjectOutputStream(new FileOutputStream("output.arch"));
//            Пишем коллекцию в поток
            objectOutputStream.writeObject(archive);
//            Закрываем поток
            objectOutputStream.close();
            System.out.println("Archive saved");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}
