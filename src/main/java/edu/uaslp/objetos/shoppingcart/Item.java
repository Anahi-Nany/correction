package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;

public class Item {
    private String itemCode;
    private String providerCode;
    private int quantity;
    private BigDecimal bigDecimal;

Item (){

}
    Item( String itemCode, String providerCode,  BigDecimal bigDecimal,int quantity){
            if (itemCode == null || itemCode == ""){
                throw new InvalidDataException("Null or empty string not allowed for item code");
            }if (providerCode == null || providerCode == ""){
                throw new InvalidDataException("Null or empty string not allowed for provider code");
            }if (bigDecimal.compareTo(new BigDecimal("0")) <= 0){
                throw new InvalidDataException("Cost must be greater than zero");
            }if (quantity < 0 || quantity > 5) {
                throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
            }
            this.itemCode = itemCode;
            this.providerCode = providerCode;
            this.bigDecimal = bigDecimal;
            this.quantity = quantity;
    }
    public void setProviderCode(String providerCode) {
        this.providerCode=providerCode;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    public void setUnitCost(BigDecimal bigDecimal) {
        this.bigDecimal=bigDecimal;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setCode(String itemCode) {
        this.itemCode=itemCode;
    }

    public String getCode() {
        return itemCode;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitCost() {
        return bigDecimal;

    }
}
