package register;

import java.util.ArrayList;

public class Basket extends Goods
{
    protected ArrayList<Goods> goodsList =new ArrayList<>();
    public String createReceipt()
    {
        String result = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < goodsList.size(); i++)
        {
            result+=goodsList.get(i).getName()+" "+goodsList.get(i).getPrice();
            builder.append(goodsList.get(i).getName()).append(" ").append(goodsList.get(i).getPrice());
            if (i<goodsList.size())
            {
                result+="\r\n";
                builder.append("\r\n");
            }
        }
        //return result;
        return builder.toString();
    }
    public int getTotalPrice() {
        int result=0;
        for (Goods goods : goodsList) {
            result+=goods.getPrice();
        }
        return result;
    }

}
