package register;

public class Employee extends User {
    private String position;
    private int salary;

    public Employee(String name, int birthYear, String address, EyeColor eyecolor, String position, int salary)
    {
        super(name, birthYear, address, eyecolor);
        this.position = position;
        this.salary = salary;
    }

    public Employee() {

    }

    public void setPosition(String position) {
        this.position = position;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }
    public int getSalary() {
        return salary;
    }

}
