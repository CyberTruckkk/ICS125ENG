
package selectcontract;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author c0527253
 */
class ContractController {
    private ContractView theView;
    private ContractModel theModel;

    ContractController(ContractView theView, ContractModel theModel) {
        this.theModel = theModel;
        this.theView = theView;
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new BidButtonListener(theModel.getTheContract()));
        this.theView.addNewContractListener(new NewContractListener());
        this.theView.addNextListener(new NextButtonListener());
        this.theView.addcomboBoxListener(new ComboListener());
        theView.setOriginCityList(theModel.getOriginCityList());
        setUpDisplay();
    }

    class PrevButtonListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (theModel.getCurrentContractNum() == 0) {
                return;
            }
            try {
                theModel.prevContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
            }
            setUpDisplay();
        }
    }

    class NewContractListener implements ActionListener {
        private NewContract newContract;

        public NewContractListener() {
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            NewContract nc;
            nc = new NewContract(theView, true);
            nc.setLocationRelativeTo(null);
            nc.setVisible(true);
        }
    }

    //not used in lab5
    class BidButtonListener implements ActionListener {
        private final Contract contract;

        public BidButtonListener(Contract contract) {
            this.contract = contract;
        }

        public void actionPerformed(ActionEvent e) {
            try {
                ConfirmBid cb;
                cb = new ConfirmBid(theView, true, theModel.getTheContract());
                cb.setLocationRelativeTo(null);
                cb.setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: The numbers entered must be integers .");
            }
        }
    }

    public void update(boolean t) {
        if (t) {
            theModel = new ContractModel();
        }
    }

    class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            final boolean toUpdate = NewContract.isUpdate;
            System.out.println("NewContract.isUpdate in nextbtn perform before update " + NewContract.isUpdate);
            update(toUpdate);
            NewContract.isUpdate = false;
            System.out.println("NewContract.isUpdate in nextbtn perform after update " + NewContract.isUpdate);
            if (theModel.getCurrentContractNum() == theModel.getContractCount()) {
                return;
            }
            System.out.println("106 pass newmodel");
            try {
                theModel.nextContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
            }
            setUpDisplay();
        }
    }

    private void setUpDisplay() {
        try {
            if (theModel.foundContracts()) {
                Contract c = theModel.getTheContract();
                theView.setContractID(c.getContractID());
                theView.setDestCity(c.getDestCity());
                theView.setOriginCity(c.getOriginCity());
                theView.setOrderItem(c.getOrderItem());
                theView.updateContractViewPanel(theModel.getCurrentContractNum(), this.theModel.getContractCount());
            } else {
                theView.setContractID("???");
                theView.setDestCity("???");
                theView.setOriginCity("???");
                theView.setOrderItem("???");
            }
            theView.updateContractViewPanel(theModel.getCurrentContractNum(), theModel.getContractCount());
            theView.setNextButton(theModel.getCurrentContractNum() < (theModel.getContractCount() - 1));
            theView.setPrevButton(theModel.getCurrentContractNum() > 0);

        } catch (Error ex) {
            System.out.println(ex);
            theView.displayErrorMessage(
                    "Error: There was a problem setting the contract.\n" +
                            " Contract Number: " + theModel.getCurrentContractNum());
        }

    }

    class ComboListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
//            System.out.println(e.getItem().toString());
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedCity = e.getItem().toString();
                System.out.println(selectedCity);
                theModel.updateContractList(selectedCity);
                setUpDisplay();
            }
        }
    }

}
