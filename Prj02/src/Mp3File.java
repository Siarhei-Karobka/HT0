/**
 * Class of mp3 file parameters.
 */
public class Mp3File {
    private String Artist;
    private String Album;
    private String Title;
    private String durationInMillis;

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
