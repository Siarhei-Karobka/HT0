import java.util.ArrayList;
import java.util.Collections;

/**
 * Method parse command line arguments to list.
 */

class ArgsParser {
    public ArrayList<String> parseArgsToList(String[] args, ArrayList<String> paths){
        if(args.length < 1){
            System.out.println("No arguments");
        } else {
            Collections.addAll(paths, args);
        }
        return paths;
    }
}
