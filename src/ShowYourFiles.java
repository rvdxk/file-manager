import java.io.File;
import java.util.Objects;
import java.util.stream.Stream;

public class ShowYourFiles
{
    public void listFilesInDirectory(String directory) //wyświetlenie listy plików
    {
        Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                //zwracanie tablicy i pobranie zawartości
                .filter(File::isFile) //przefiltrowanie by tablica zawierała tylko pliki
                .map(File::getName) //pobranie nazw plików
                .forEach(System.out::println);
    }

    public void sortFilesInDirectory(String directory) //wyświetlenie posortowanej listy plików
    {

        Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(File::isFile)
                .sorted((o1, o2) -> Long.compare(o2.length(), o1.length())) //sortowanie wielkości -> malejąco
                .forEach(file ->
                {
                    System.out.println("File: " + file.getName()); //nazwa
                    System.out.println("Size: " + file.length() + " Byte"); //wielkość
                    System.out.println();
                });
    }
}
