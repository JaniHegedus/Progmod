package register;

public class Goods
{
    private String name;
    private int price;

    public Goods() {
    }

    public Goods(String name, int prize) {
        this.name = name;
        this.price = prize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
