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
    public void addGoods(Goods name)
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
            super.goodsList.add(name);
        }
    }
    public void updatePrice(String name, int price)
    {
        for (int i = 0; i < super.goodsList.size(); i++) {
            if(super.goodsList.get(i).getName()==name)
            {
                super.goodsList.get(i).setPrice(price);
            }
        }
    }
    public void removeGoods(Goods name)
    {
        for (int i = 0; i < super.goodsList.size(); i++) {
            if(super.goodsList.get(i) == name)
            {
                super.goodsList.remove(i);
            }
        }
    }
}
