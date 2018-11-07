import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        List<File> mp3LocationList;
        ArrayList<Mp3File> listWithMp3 = new ArrayList<>();

        AudioParser audioParser = new AudioParser();
        FileSearcher fileSearcher = new FileSearcher();

        mp3LocationList = fileSearcher.getListWithFoundedMp3();

        fileSearcher.findMp3(args); //find mp3's from folders in command line parameters

        audioParser.createListWithMp3(listWithMp3, mp3LocationList);

        System.out.println(mp3LocationList);
    }
}
