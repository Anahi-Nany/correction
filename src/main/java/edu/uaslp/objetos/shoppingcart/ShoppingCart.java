package edu.uaslp.objetos.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class ShoppingCart {
    List <Item> shoppingCart = new ArrayList<>();
    private BigDecimal totalCost;
    //int itemsCount;

    public boolean isEmpty() {
        /*if( shopingCart.size()>0){
            return false;
        }
        return true;*/
        return shoppingCart.size() == 0;
    }

    public void addItem(Item item) {
        /*shoppingCart.add(item);
        itemsCount++;*/

        if(item.getCode() == null){
            throw new InvalidDataException("Null or empty string not allowed for item code");
        }

        if(item.getProviderCode().isEmpty()){
            throw new InvalidDataException("Null or empty string not allowed for provider code");
        }

        if(item.getUnitCost().compareTo(BigDecimal.ZERO)<0){
            throw new InvalidDataException("Cost must be greater than zero");
        }

        if(item.getQuantity() < 1 || item.getQuantity() > 5){
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }

        for(Item existentItem: shoppingCart){
            if(existentItem.getCode().equals(item.getCode()) && existentItem.getUnitCost().compareTo(item.getUnitCost()) == 0){
                existentItem.setQuantity(existentItem.getQuantity() + item.getQuantity());
                return;
            }
        }

        shoppingCart.add(item);

    }

    public int getItemsCount() {
        int count = 0;
        for(Item item: shoppingCart){
            count = count + item.getQuantity();
        }
        return count;
    }

    public List<Item> getItems() {
        return shoppingCart;
    }

    public BigDecimal getTotalCost(){
        //return totalCost;
        BigDecimal totalCost = BigDecimal.ZERO;

       // Item[] shoppingCartList;
        for(Item item: shoppingCart){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        if (shoppingCart.size()==0){
            throw new EmptyShoppingCartException();
        }

        return totalCost;
    }

    public void removeItem(String code) {
        //shoppingCart.remove(item);
        for(Item item : shoppingCart){
            if(item.getCode().equals(code)){
                item.setQuantity(item.getQuantity() - 1);

                if(item.getQuantity() == 0){
                    shoppingCart.remove(item);
                }
                return;
            }
        }
    }
}
