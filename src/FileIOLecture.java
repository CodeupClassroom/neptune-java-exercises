import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIOLecture {

    public static void main(String[] args) {
//        Path path = Paths.get("src");
//        System.out.println(path);
//        System.out.println(path.toAbsolutePath());

//        Path path = Paths.get("src", "FileIOLecture.java");
//        System.out.println(path);
//        System.out.println(path.toAbsolutePath());
//        Path pathToSrc = Paths.get("src");
//        System.out.println(pathToSrc);
//        //Path thisWontWork = Paths.get(pathToSrc, "FileIOLecture.java");
//        Path thisWillWork = Paths.get(String.valueOf(pathToSrc), "FileIOLecture.java");
//        System.out.println(thisWillWork);

        Path toOurDataPlace = Paths.get("src/data");
//        System.out.println(toOurDataPlace);
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "data.txt");
        // Path toOurDataFile = Paths.get("src/data/data.txt");


        // Create a directory

//        try {
//            if (Files.notExists(toOurDataPlace)){
//                Files.createDirectories(toOurDataPlace);
//            } else {
//                System.out.println("The " + toOurDataPlace + " directory already exists.");
//            }
//        } catch (IOException ioe){
//            ioe.printStackTrace();
//        }

//        System.out.println(toOurDataFile);

        // Create a File

       try {
           if (Files.notExists(toOurDataFile)){
               Files.createFile(toOurDataFile);
           }
       } catch (IOException ioe) {
           ioe.printStackTrace();
       }

       // Write to a file

        List<String> romanEmpresses = Arrays.asList("Livia", "Agrippina", "Messaline", "Julia Domna");

       try {
           Files.write(toOurDataFile, romanEmpresses);
       } catch (IOException ioe){
           ioe.printStackTrace();
       }

    }
}
