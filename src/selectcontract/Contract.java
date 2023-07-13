package selectcontract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Contract {
    private String contractID;
    private String originCity;
    private String destCity;
    private String orderItem;
    private String checker;
    public final String[] Citys = {"Victoria", "Vancouver", "Seattle", "Nanaimo", "Prince George"};
    ArrayList<String> orderidList;
    public static String newContractSave = System.getProperty("user.dir") + "\\src\\selectcontract\\contracts.txt";
    public static boolean boolMatch = false;

    public Contract(String contractID, String originCity, String destCity, String orderItem) {
        this.contractID = contractID;
        this.originCity = originCity;
        this.destCity = destCity;
        this.orderItem = orderItem;
        orderidList = new ArrayList<>();
    }

    public void getOrderIdList() {
        String[] token;
        try (FileReader fileReader = new FileReader(newContractSave);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(newContractSave));) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                token = line.split(",", 4);
                String id = token[0];
                this.orderidList.add(id);
            }
//            System.out.println(Arrays.stream(orderidList.toArray()).toList());
            fileReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setContractID(String contractID) {
        getOrderIdList();
        contractID = contractID.toUpperCase();
        System.out.println(this.orderidList.contains(contractID));
        if (this.orderidList.contains(contractID)) {
            System.out.println("id duplicated");
            return;
        }
        System.out.println("dup check fail");
        boolMatch = contractID.matches("[1-9][a-zA-Z]{3}");
        if (!boolMatch) {
            checker = "invalid orderID format:[1-9][a-zA-Z]{3}";
            return;
        }
//        System.out.println("id format check pass");
        Boolean dup = this.orderidList.contains(contractID);
        System.out.println("boolean dup is contains " + dup);
        if (dup) {
            checker = "dublicated order id";
            return;
        }
        System.out.println(checker);
        if (boolMatch && !dup) {
            checker = "orderID pass";
            System.out.println(checker);
            this.contractID = contractID.toUpperCase();
            System.out.println("assign id pass");
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
        if (orderItem.isBlank()) {
            checker = "item may not be empty";
        } else if (orderItem.matches("\\d+")) {
            checker = "Order items cannot be  exclusively numbers (e.g. 1234 is not a valid order item)";
        } else if (orderItem.contains(",")) {
            checker = "An order item may not contain comma  characters";
        } else {
            this.orderItem = orderItem;
            checker = "orderItem pass";
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
