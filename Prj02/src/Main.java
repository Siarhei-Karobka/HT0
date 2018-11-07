import java.util.ArrayList;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> paths = new ArrayList<>();
        ArrayList<String> mp3LocationList = new ArrayList<>();
        ArrayList<Mp3File> listWithMp3 = new ArrayList<>();

        ArgsParser argsParser = new ArgsParser();
        argsParser.parseArgsToList(args,paths);

        AudioParser audioParser = new AudioParser();
        FileSearcher fileSearcher = new FileSearcher();

        fileSearcher.findMp3(paths, mp3LocationList);

        audioParser.createListWithMp3(listWithMp3, mp3LocationList);
        System.out.println(listWithMp3);
    }
}
