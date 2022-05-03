package edu.uaslp.objetos.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List <Item>  shopingCart = new ArrayList<>();
    int totalCost;
    int itemsCount;

    public boolean isEmpty() {
        if( shopingCart.size()>0){
            return false;
        }
        return true;
    }

    public void addItem(Item item) {
        shopingCart.add(item);
        itemsCount++;
    }


    public int getItemsCount() {
        return itemsCount;
    }

    public List<Item> getItems() {
        return shopingCart;
    }

    public int getTotalCost(){
        return totalCost;
    }

    public void removeItem(String item) {
        shopingCart.remove(item);
    }
}
