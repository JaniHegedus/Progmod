package register;

public class Shopping extends Basket{
    public void addGoods(String name, int price)
    {
        boolean contains = false;
        for(Goods goods:goodsList)
        {
            if(goods.equals(name))
            {
                contains=true;
            }
        }
        if(!contains)
        {
            super.goodsList.add(new Goods(name,price));
        }
    }
}
