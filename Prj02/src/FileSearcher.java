import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Find files with extension .mp3 and add them to list.
 */
public class FileSearcher {
    private final List<File> listWithFoundedMp3 = new ArrayList<>();

    public List<File> getListWithFoundedMp3() {
        return listWithFoundedMp3;
    }

    /**
     * recursion method find files in folder and subfolder.
     */
    public void findMp3(String[] paths) {
        List<File> directories = new ArrayList<>();
        if (paths.length == 0) {
            System.out.println("No directories to scan");
        }
        for (String path : paths) {
            directories.add(new File(path));
        }

        for (File directory : directories)
            try {
                for (File dirItem : directory.listFiles()) {
                    //check extension
                    if (dirItem.isFile() && (Objects.equals(FilenameUtils.getExtension(String.valueOf(dirItem)), "mp3"))) {
                        listWithFoundedMp3.add(dirItem);
                    } else if (dirItem.isDirectory()) {
                        String[] iterableListOfDirs = {dirItem.getAbsolutePath()};
                        findMp3(iterableListOfDirs);
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("directory " + directory + " not found");
            }
    }
}