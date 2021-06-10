import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FileIOLecture {

    public void readFileAndOuput (Path pathToFile){
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(pathToFile);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        for (String line: currentList) {
            System.out.println(line);
        }
    }

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

//       try {
//           if (Files.notExists(toOurDataFile)){
//               Files.createFile(toOurDataFile);
//           }
//       } catch (IOException ioe) {
//           ioe.printStackTrace();
//       }
//
//       // Write to a file
//
//        List<String> romanEmpresses = Arrays.asList("Livia", "Agrippina", "Messaline", "Julia Domna");
//
//       try {
//           // 2 arguments for Files.write
//           // The path to our file, the data we want to write
//           Files.write(toOurDataFile, romanEmpresses);
//       } catch (IOException ioe){
//           ioe.printStackTrace();
//       }
//
//       // Read from a file
//
//       // create a place to put information we read from the file
////       List<String> currentList = new ArrayList<>();
////
////       // read the information from the file
////       try {
////           currentList = Files.readAllLines(toOurDataFile);
////       } catch (IOException ioe){
////           ioe.printStackTrace();
////       }
////
////       // loop through the ArrayList and output each item
////       for (String line: currentList) {
////           System.out.println(line);
////       }

        FileIOLecture io = new FileIOLecture();
//        io.readFileAndOuput(toOurDataFile);

        // Append a single item to our list

//        try {
//            Files.writeString(toOurDataFile, "Julia Maesa\n", StandardOpenOption.APPEND);
//        } catch (IOException ioe){
//            ioe.printStackTrace();
//        }
//
////        io.readFileAndOuput(toOurDataFile);
//
//        // Append a list to a list
//
//        List<String> lateRomanEmpresses = new ArrayList<>();
//        lateRomanEmpresses.add("Galla Placidia");
//        lateRomanEmpresses.add("Theodora");
//        lateRomanEmpresses.add("Licinia Eudoxia");
//
//        try {
//            Files.write(toOurDataFile, lateRomanEmpresses, StandardOpenOption.APPEND);
//        } catch (IOException ioe){
//            ioe.printStackTrace();
//        }

//        io.readFileAndOuput(toOurDataFile);

        // Iterate over a list and remove one item

//        List<String> currentList = new ArrayList<>();
//        try {
//            currentList = Files.readAllLines(toOurDataFile);
//        } catch (IOException ioe){
//            ioe.printStackTrace();
//        }
//        Iterator<String> listIterator = currentList.iterator();
//        while(listIterator.hasNext()){
//            String empress = listIterator.next();
//            if (empress.equals("Messaline")){
//               listIterator.remove();
//            }
//        }
//        try {
//            Files.write(toOurDataFile, currentList);
//        } catch (IOException ioe){
//            ioe.printStackTrace();
//        }

        try {
            Files.writeString(toOurDataFile, "Messalina\n", StandardOpenOption.APPEND);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        io.readFileAndOuput(toOurDataFile);
    }
}
