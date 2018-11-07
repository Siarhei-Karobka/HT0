import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

/**
 * This method should create Html file with mp3.
 */
public class CreatorHTML {
    public StringBuilder buildHTMLTable(TreeSet<Mp3File> listWithMp3) {
        StringBuilder sb = new StringBuilder();

        sb.append("<!DOCTYPE html>").append("<html>").append("<head>").
                append("<title>mp3 list</title>").append("</head>").
                append("<body>").append("<table border = '1'>");

        for (Mp3File mp3File : listWithMp3) {
            String artist = (mp3File.getArtist() != null) ? mp3File.getArtist() : "Unknown Artist";
            String album = (mp3File.getAlbum() != null) ? mp3File.getAlbum() : "Unknown Album";
            String title = (mp3File.getTitle() != null) ? mp3File.getTitle() : "Unknown Song";
            String duration = mp3File.getDuration();
            String localPath = mp3File.getPath();

//            if (Objects.equals(artist, mp3File.getArtist())){
//                sb.append("<td>").append(album).append("</td>").
//                        append("<td>").append(title).append("</td></tr>");
//            }
//

            sb.append("<tr><td>").append(artist).append("</td>").
                    append("<td>").append(album).append("</td>").
                    append("<td>").append(title).append("</td>").
                    append("<td>").append(duration).append("</td>").
                    append("<td>").
                    append("<a href = ").append(localPath).append(">Link</a>").
                    append("</td></tr>");
        }

        sb.append("<table>").append("</body>").append("</html>");
        return sb;
    }

    public void createHTMLFile(String mp3) {
        File file = new File("D:\\mp3List.html");
        FileWriter writer = null;

        try {
            file.createNewFile();
            writer = new FileWriter(file);
            writer.write(mp3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
