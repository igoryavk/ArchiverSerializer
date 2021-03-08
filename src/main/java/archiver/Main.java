package archiver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Archiver archiver=new Archiver(args);
//        archiver.SerializeData();
//        archiver.showData();
//        archiver.ZipData();
          if (args.length!=0)
          {
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
                      Dearchiver dearchiver=new Dearchiver();
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
//          Dearchiver dearchiver=new Dearchiver();
//
//          dearchiver.DeserializeData();
    }
}
