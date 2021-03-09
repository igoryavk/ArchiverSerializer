package archiver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//         В main получим массив аргументов и после предварительной
//         обработки переда его в те объекты, которые будут выпонять
//         для нас архивацию/деархивацию.
//
//         Проверяем, что аргументы переданы

          if (args.length!=0)
          {
//              Делаем меню выбора режимов архивации/деархивации и
//              и проверку на неправильный ввод
              switch (args[0])
              {
                  case "-a":{
                      if (args.length>1)
                      {
                          String[] filenames=new String[args.length-1];
                          for(int i=1;i<args.length;i++)
                          {
                              filenames[i-1]=args[i];
                          }
                          Archiver archiver=new Archiver(filenames);

                      }
                      else {
                          System.out.println("Please specify a list of files");
                      }
                      break;
                  }
                  case "-d":{
                      if (args.length==2)
                      {
                          String filename=args[1];
                          Dearchiver dearchiver=new Dearchiver(filename);
                      }
                      else {
                          System.out.println("Please specify an output.arch");
                      }


                      break;
                  }
                  default: {
                      System.out.println("Wrong input. Please type:");
                      System.out.println("-a LIST_OF_FILES - for archiving");
                      System.out.println("-d - for dearchiving");
                  }
              }
          }
          else
              {
                  System.out.println("Wrong input. Please type:");
                  System.out.println("-a LIST_OF_FILES - for archiving");
                  System.out.println("-d - for dearchiving");
              }

    }
}
