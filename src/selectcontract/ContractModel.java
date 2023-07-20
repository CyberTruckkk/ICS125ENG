
package selectcontract;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author c0527253
 */
class ContractModel {
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_ORIGIN_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_ORDER_ITEM = 3;
    private  SortedSet<String> originCityList;
    private int contractCounter;
    private ArrayList<Contract> theContracts;
    private ArrayList<Contract> theContractsAll;

    public ContractModel() {
//        this.contractCounter = 0;
        this.theContracts = new ArrayList<>();
        this.originCityList = new TreeSet<>();
        this.theContractsAll = new ArrayList<>();
        loadingContracts(true);

    }

    public void loadingContracts(boolean update) {
        if(!update)return;
        try {
            File file = new File(NewContract.newContractSaveXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList contractList = doc.getElementsByTagName("contract");

            for (int i = 0; i < contractList.getLength(); i++) {
                Node contractNode = contractList.item(i);

                if (contractNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element contractElement = (Element) contractNode;

                    String contractID = getAtttibute(contractElement, "contractID");
                    String oCity = getAtttibute(contractElement, "originCity");
                    String dCity = getAtttibute(contractElement, "destCity");
                    String oItem = getAtttibute(contractElement, "orderItem");

                    Contract contract = new Contract(contractID, oCity, dCity, oItem);
                    this.theContracts.add(contract);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

//        for (Contract contract : theContracts) {
//            String originCity = contract.getOriginCity();
//            originCityList.add(originCity);
//        }
//
//        theContractsAll = new ArrayList<>(theContracts);
//        originCityList.add("All");

        reloadOcityList(true);
    }

    private String getAtttibute(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        Node node = nodeList.item(0);

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element tagElement = (Element) node;
            return tagElement.getTextContent();
        }

        return "";
    }

    public String[] getOriginCityList() {
        String[] a;
        a = originCityList.toArray(new String[originCityList.size()]);
        return a;
    }

    public void reloadOcityList(boolean t){
        if(t){
            for (Contract contract : theContracts) {
                String originCity = contract.getOriginCity();
                originCityList.add(originCity);
            }

            theContractsAll = new ArrayList<>(theContracts);
            originCityList.add("All");
        }

    }
    public void updateContractList(String city) {
        theContracts = new ArrayList<>(theContractsAll);
        if (city != "All") {
            theContracts.removeIf(s -> !s.contains(city));
        }
//        contractCounter = 0;
    }

    public boolean foundContracts() {
        return this.theContracts.size() > 0;
    }

    public Contract getTheContract() {
        return this.theContracts.get(this.contractCounter);
    }

    public int getContractCount() {
        return this.theContracts.size();
    }

    public int getCurrentContractNum() {
        return this.contractCounter;
    }

    public void nextContract() {
        System.out.println("nextContract()" + contractCounter + " < ?" + (this.getContractCount() - 1));
        if (this.contractCounter < (this.getContractCount() - 1)) {
            this.contractCounter++;
            System.out.println("in if , contractCounter" +contractCounter);
        }
    }

    public void prevContract() {
        System.out.println("prevContract()");
        if (this.contractCounter > 0) {
            this.contractCounter--;
        }
    }

}
