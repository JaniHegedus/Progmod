package register;

public class Apple extends Fruit
{
    protected int pieces;
    protected Color color;

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
    public Color getColor()
    {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
