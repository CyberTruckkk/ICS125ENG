package selectcontract;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author wenlong
 */
public class ConfirmBid extends JDialog {

    private Contract theContract;
    private String optionsFileName;

    /**
     * Creates new form ConfirmBid
     */
    public ConfirmBid(JFrame f, boolean m, Contract theContract) {
        super(f, m);
        initComponents();
        this.theContract=theContract;
        this.JLabelContractlD.setText(theContract.getContractID());
        this.JLabelOrigin.setText(theContract.getOriginCity());
        this.JLabelDestination.setText(theContract.getDestCity());
        this.JLabelOrderltem.setText(theContract.getOrderItem());
        Integer startValue = 100;
        Integer minValue = 100;
        Integer maxValue = 10000;
        Integer stepValue = 50;
        SpinnerModel numModel = new SpinnerNumberModel(startValue, minValue, maxValue, stepValue);
        jSpinner1.setModel(numModel);
//        optionsFileName = System.getProperty("user.dir") + "\\src\\selectcontract\\output_bids.txt";
        optionsFileName = System.getProperty("user.dir") + "\\src\\selectcontract\\output_bids.txt";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLabelContractlD = new javax.swing.JLabel();
        JLabelOrigin = new javax.swing.JLabel();
        JLabelDestination = new javax.swing.JLabel();
        JLabelOrderltem = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        JButtonSave = new javax.swing.JButton();
        JButtonCancel = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuNewContract = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" Place bid on selected contract");
        setName("JDialog"); // NOI18N

        jLabel1.setText("You are placing a bid on the selected contract.");

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel3.setText("Origin");

        jLabel2.setText("ContractID");

        jLabel4.setText("Destination");

        jLabel5.setText("Order");

        JLabelContractlD.setText("JLabelContractlD");

        JLabelOrigin.setText("jLabel7");

        JLabelDestination.setText("jLabel8");

        JLabelOrderltem.setText("jLabel9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabelContractlD, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLabelDestination, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabelOrderltem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelContractlD)
                    .addComponent(JLabelOrigin)
                    .addComponent(JLabelDestination)
                    .addComponent(JLabelOrderltem))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(100, 100, 10000, 50));
        jSpinner1.setToolTipText("");
        jSpinner1.setName(""); // NOI18N
        jSpinner1.setOpaque(true);

        JButtonSave.setText("Save");
        JButtonSave.setToolTipText("");
        JButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonSaveActionPerformed(evt);
            }
        });

        JButtonCancel.setText("Cancel");
        JButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCancelActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuNewContract.setText("jMenuNewContract");
        jMenuNewContract.setToolTipText("");
        jMenuNewContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNewContractActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuNewContract);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(JButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(JButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonCancel)
                    .addComponent(JButtonSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonSaveActionPerformed
//        System.out.println(jSpinner1.getValue());
//        String fileName = "M:\\125GIT\\SelectContract\\src\\selectcontract\\MyContractBids.txt";
       // M:\125GIT\SelectContract\src\selectcontract
        try {
            BufferedWriter newWrite = new BufferedWriter(new FileWriter(optionsFileName, true));
            ZonedDateTime currentDate;
            currentDate = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'  'HH:mm:ss 'PST'");
            String time = formatter.format(currentDate);
            double amount = Double.valueOf(jSpinner1.getValue().toString());
            Locale locale = new Locale("en", "CA");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            String formattedAmount = currencyFormatter.format(amount);
            String name = jTextName.getText();
            String str = name + "," + JLabelContractlD.getText() + "," + formattedAmount + "," + time;
            if (!name.isBlank() &&name.chars().allMatch(Character::isAlphabetic)) {
                newWrite.write(str);
                newWrite.newLine();
                newWrite.close();
//                System.out.println("Successfully wrote to the file.");
                String str2 = "Your name as " + name + " with bid amount " + formattedAmount + " has been successfully saved";
                JOptionPane.showMessageDialog(null, str2);
            } else {
                JOptionPane.showMessageDialog(null, "Your name contains non-alphabetics characters");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_JButtonSaveActionPerformed

    private void JButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCancelActionPerformed
        dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_JButtonCancelActionPerformed

    private void jMenuNewContractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNewContractActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuNewContractActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCancel;
    private javax.swing.JButton JButtonSave;
    private javax.swing.JLabel JLabelContractlD;
    private javax.swing.JLabel JLabelDestination;
    private javax.swing.JLabel JLabelOrderltem;
    private javax.swing.JLabel JLabelOrigin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuNewContract;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextName;
    // End of variables declaration//GEN-END:variables
}
