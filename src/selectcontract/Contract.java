package selectcontract;

import java.util.Arrays;

public class Contract {
    private String contractID;
    private String originCity;
    private String destCity;
    private String orderItem;
    private String checker;
    public final String[] Citys = {"Victoria", "Vancouver", "Seattle", "Nanaimo", "Prince George"};

    public Contract(String contractID, String originCity, String destCity, String orderItem) {
        this.contractID = contractID;
        this.originCity = originCity;
        this.destCity = destCity;
        this.orderItem = orderItem;
    }

    public void setContractID(String contractID) {
        if (!contractID.matches("[1-9][a-zA-Z]{3}")) {
            checker = "invalid orderID format:[1-9][a-zA-Z]{3}";
            return;
        } else if(contractID.matches("[1-9][a-zA-Z]{3}")){
            checker = "orderID pass";
            this.contractID = contractID.toUpperCase();
        }
    }

    public void setOriginCity(String originCity) {
        if (Arrays.asList(Citys).contains(originCity) && !originCity.equals(this.getDestCity())) {
            this.originCity = originCity;
            checker = "originCity pass";
        } else {
            checker = "invalid origincity or origincity eauqals destcity";
        }

    }

    public void setDestCity(String destCity) {
        if (Arrays.asList(Citys).contains(destCity) && !destCity.equals(this.getOriginCity())) {
            this.destCity = destCity;
            checker = "destCity pass";
        } else {
            checker = "invalid destCity or origincity eauqals destcity";
        }
    }

    public void setOrderItem(String orderItem) {
        if (orderItem.matches("\\d+")) {
            checker = "Order items cannot be  exclusively numbers (e.g. 1234 is not a valid order item)";
        } else if (orderItem.contains(",")) {
            checker = "An order item may not contain comma  characters";
        } else {
            this.orderItem = orderItem;
            checker="orderItem pass";
        }
    }

    public String getContractID() {
        return contractID;
    }

    public String getOriginCity() {
        return originCity;
    }

    public String getDestCity() {
        return destCity;
    }

    boolean contains(String city) {
        return originCity.equals(city);
    }

    public String getOrderItem() {
        return orderItem;
    }

    public String getChecker() {
        return checker;
    }
}
