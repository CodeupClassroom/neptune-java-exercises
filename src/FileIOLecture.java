import java.io.IOException;
import java.nio.file.*;

public class FileIOLecture {

    public static void main(String[] args) {
//        Path path = Paths.get("src");
//        System.out.println(path);
//        System.out.println(path.toAbsolutePath());

        Path path = Paths.get("src", "FileIOLecture.java");
        System.out.println(path);
        System.out.println(path.toAbsolutePath());

    }
}
