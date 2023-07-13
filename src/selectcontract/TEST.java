package selectcontract;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
        String s = "passska";
        String c = "passs";
        System.out.println(s.contains(c));
        List<String> list= new ArrayList<String>();
        list.add(s);
        list.add(c);
        String ch = "passs";
        System.out.println(list.contains(ch));
        System.out.println(list.contains("passs"));
        System.out.println(list.toString());
    }
}
