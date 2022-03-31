package register;

import java.util.ArrayList;

public class PublicTransport extends PublicVehicle
{
    private ArrayList arrayLists = new ArrayList();

    protected ArrayList<PublicVehicle> publicVehicles = new ArrayList<>();
    protected ArrayList<Metro> metros = new ArrayList<>();
    protected ArrayList<Tram> trams = new ArrayList<>();
    protected ArrayList<Bus> busses = new ArrayList<>();

    public void addVehicle(PublicVehicle publicVehicle)
    {
        this.publicVehicles.add(publicVehicle);
        this.arrayLists.add(publicVehicles);
    }
    public void addVehicle(Bus bus)
    {
        this.busses.add(bus);
        this.arrayLists.add(busses);
    }
    public void addVehicle(Tram tram)
    {
        this.trams.add(tram);
        this.arrayLists.add(trams);
    }
    public void addVehicle(Metro metro)
    {
        this.metros.add(metro);
        this.arrayLists.add(metros);
    }
    public ArrayList getVehicles()
    {
        return arrayLists;
    }
}
