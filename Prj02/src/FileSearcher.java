import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Find files with extension .mp3 and add them to list.
 */
public class FileSearcher {

    public ArrayList<String> findMp3 (ArrayList<String> paths, ArrayList<String> listWithFoundedMp3){ //TODO add recursion
        List<File> directories = new ArrayList<>();
        for (String dirName : paths) {
            File dir = new File(dirName);

            String EXTENSION = ".mp3";
            String[] filenames = dir.list(new ExtensionFilter(EXTENSION));

            for (String filename : filenames) {
                listWithFoundedMp3.add(dirName + "\\" + filename);
            }
        }
        return listWithFoundedMp3;
    }
}

class ExtensionFilter implements FilenameFilter {

    private final String extension;

    public ExtensionFilter(String ext) {
        extension = ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }

}