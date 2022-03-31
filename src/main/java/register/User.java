package register;

public class User {
    private String name;
    private int birthYear;
    private String address;
    private final EyeColor eyecolor;

    public User()
    {
        this("John Doe", 1985, "Baker Street", EyeColor.BROWN);
    }

    public User(String name, int birthYear, String address) {
        this.name = name;
        this.birthYear = birthYear;
        this.address = address;
        this.eyecolor = EyeColor.BROWN;
    }
    public User(String name, int birthYear, String address, EyeColor eyecolor) {
        this.name = name;
        this.birthYear = birthYear;
        this.address = address;
        this.eyecolor = eyecolor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int ageIn(int year) {
        if (year < birthYear) {
            return 0;
        }
        return year - birthYear;
    }

    public EyeColor getEyeColor() {
        return eyecolor;
    }

    @Override
    public String toString() {
        return name;
    }
}
