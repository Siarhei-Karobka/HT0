import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        List<File> mp3LocationList;
        Comparator<Mp3File> mp3Comp = new Mp3ArtistComparator().thenComparing(new Mp3AlbumComparator().
                thenComparing(new Mp3TitleComparator()));
        TreeSet<Mp3File> listWithMp3 = new TreeSet<>(mp3Comp);


        AudioParser audioParser = new AudioParser();
        FileSearcher fileSearcher = new FileSearcher();

        mp3LocationList = fileSearcher.getListWithFoundedMp3();

        fileSearcher.findMp3(args); //find mp3's from folders in command line parameters

        audioParser.createListWithMp3(listWithMp3, mp3LocationList);

        CreatorHTML creatorHTML = new CreatorHTML();
        StringBuilder stringBuilder = creatorHTML.buildHTMLTable(listWithMp3);
        String mp3 = stringBuilder.toString();
        creatorHTML.createHTMLFile(mp3);
    }
}
