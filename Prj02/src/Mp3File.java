import java.util.Comparator;

/**
 * Class of mp3 file parameters.
 */
public class Mp3File {
    private String Artist;
    private String Album;
    private String Title;
    private String durationInMillis;
    private String path;

    public String getPath() {
        return "file:///" + path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDuration() {
        return convertLongDurationFromSeconds(durationInMillis);
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDurationInMillis(String durationInMillis) {
        this.durationInMillis = durationInMillis;
    }

    private String convertLongDurationFromSeconds(String duration) {
        Double dur = Double.parseDouble(duration);
        long seconds = (long) ((dur / 1000) % 60);
        long minutes = (long) ((dur / (1000 * 60)) % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }


    @Override
    public String toString() {
        return "\nMp3File{" +
                "Artist='" + Artist + '\'' +
                ", Album='" + Album + '\'' +
                ", Title='" + Title + '\'' +
                ", duration='" + convertLongDurationFromSeconds(durationInMillis) + '\'' +
                '}';
    }
}

class Mp3ArtistComparator implements Comparator<Mp3File> {
    @Override
    public int compare(Mp3File o1, Mp3File o2) {
        return o1.getArtist().compareTo(o2.getArtist());
    }
}

class Mp3AlbumComparator implements Comparator<Mp3File> {
    @Override
    public int compare(Mp3File o1, Mp3File o2) {
        return o1.getAlbum().compareTo(o2.getAlbum());
    }
}

class Mp3TitleComparator implements Comparator<Mp3File> {
    @Override
    public int compare(Mp3File o1, Mp3File o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
