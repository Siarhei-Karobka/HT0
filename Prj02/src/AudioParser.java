import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.TreeSet;

/**
 * Method takes .mp3 tags and set them as Mp3 object parameters.
 */
public class AudioParser {

    public TreeSet<Mp3File> createListWithMp3(TreeSet<Mp3File> list, List<File> mp3LocationList) {
        for (File fileLocation : mp3LocationList) {
            try {
                Mp3File mp3File = new Mp3File();

                InputStream input = new FileInputStream(new File(String.valueOf(fileLocation)));
                ContentHandler handler = new DefaultHandler();
                Metadata metadata = new Metadata();
                Parser parser = new Mp3Parser();
                ParseContext parseCtx = new ParseContext();
                parser.parse(input, handler, metadata, parseCtx);
                input.close();

                mp3File.setTitle(metadata.get("title"));
                mp3File.setArtist(metadata.get("xmpDM:artist"));
                mp3File.setAlbum(metadata.get("xmpDM:album"));
                mp3File.setDurationInMillis(metadata.get("xmpDM:duration"));
                mp3File.setPath(fileLocation.getAbsolutePath());

                list.add(mp3File);

            } catch (IOException | SAXException | TikaException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}