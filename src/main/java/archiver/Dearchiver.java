package archiver;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Dearchiver {
    private Archive archive;
    private ObjectInputStream objectInputStream;
    private FileOutputStream outputStream;
    private String filename;
    public Dearchiver(String filename) {
//        Делаем проверку разделителей в пути для разных операционных систем
        char winSeparator='\\';
        char nixSeparator='/';
//            В зависимости от разделителя который ввел пользователь
//            будут проверены Windows и Unix разделители и если ввод был
//            неправильным, программа заменит их на нужный разделитель
        filename=filename.replace(winSeparator,File.separatorChar);
        filename=filename.replace(nixSeparator,File.separatorChar);

//        Создаем объект архива
        archive=new Archive();
        try {
        this.filename = filename;
//        Получаем информацию об упакованном файле
        File file=new File(filename);
//        Проверяем существует ли он
        if(file.exists()){
//            Если существует, то создаем поток объединенный с ним
            objectInputStream = new ObjectInputStream(new FileInputStream(filename));
//            Читаем из потока сериализованные ранее данные и записываем их в объект-архив
            archive = (Archive) objectInputStream.readObject();
        }
        else {
            System.out.println(filename+ " - file not found");
        }
        } catch (IOException | ClassNotFoundException exception)
        {
            System.out.println(exception.getMessage());
        }
//        Если в архиве есть данные выполняем их распаковку
        if(archive.getItemsNumber()!=0) {
            DeserializeData();
        }
    }

    public void DeserializeData(){
//        Получаем поток для коллеции и информацию из каждого элемента
//        записываем в файлы
        archive.getItemList().stream().forEach(item -> {
            try {
//                Получаем выходной поток
                outputStream=new FileOutputStream(item.getName());
//                Пишем сохраненную информацию в файл
                outputStream.write(item.getBuffer());
//                Закрываем поток
                outputStream.close();
                System.out.println("Data dearchived");
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }


}
