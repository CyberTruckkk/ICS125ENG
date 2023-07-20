
package selectcontract;

/**
 *
 * @author c0527253
 */
public class SelectContract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ContractView theView = new ContractView();
        ContractModel theModel = new ContractModel();
        ContractController theController;
        theController = new ContractController(theView,theModel);
        theView.setVisible(true);

    }
    
}
