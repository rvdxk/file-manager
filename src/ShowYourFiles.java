import java.io.File;
import java.util.Objects;
import java.util.stream.Stream;

public class ShowYourFiles
{
    public void listFilesInDirectory(String directory)
    {
        Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(File::isFile)
                .map(File::getName)
                .forEach(System.out::println);
    }

    public void sortFilesInDirectory(String directory)
    {

        Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(File::isFile)
                .sorted((o1, o2) -> Long.compare(o2.length(), o1.length()))
                .forEach(file ->
                {
                    System.out.println("File: " + file.getName());
                    System.out.println("Size: " + file.length() + " Byte");
                    System.out.println();
                });
    }
}
