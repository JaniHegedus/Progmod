package register;

public class Song
{
    private String band;
    private String Title;
    private double LengthInMinutes;
    public Song(){}
    public Song(String band, String title, double LengthInMinutes) {
        this.band=band;
        this.Title=title;
        this.LengthInMinutes=LengthInMinutes;
    }

    public void setBand(String band)
    {
        this.band=band;
    }

    public String getBand() {
        return band;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public double getLengthInMinutes() {
        return LengthInMinutes;
    }

    public void setLengthInMinutes(double lengthInMinutes) {
        LengthInMinutes = lengthInMinutes;
    }
}
