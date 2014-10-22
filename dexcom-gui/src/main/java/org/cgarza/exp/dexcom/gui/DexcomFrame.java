package org.cgarza.exp.dexcom.gui;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.usb.UsbClaimException;
import javax.usb.UsbConfiguration;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbEndpoint;
import javax.usb.UsbException;
import javax.usb.UsbInterface;
import javax.usb.UsbNotActiveException;
import org.cgarza.exp.dexcom.DexComConnection;
import org.cgarza.exp.dexcom.UsbDeviceHub;
import org.cgarza.exp.dexcom.UsbUtils;
import org.cgarza.exp.dexcom.exceptions.DexComException;
import org.cgarza.exp.dexcom.exceptions.DexComNotFoundException;
import org.cgarza.exp.utils.ByteWaster;
import org.cgarza.exp.utils.Debug;

public class DexcomFrame extends javax.swing.JFrame {

    public DexcomFrame() {
        initComponents();
        userInit();
    }

    private void userInit() {
        fdx = new ColoredTextPane(findDexcomPaneRaw);
        dbg = new ColoredTextPane(debugPaneRaw);
        wastedBytes = new ArrayList<ByteWaster>();
        dexcom = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        usbTab = new javax.swing.JPanel();
        findDexComButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        findDexcomPaneRaw = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        usbDeviceTextField = new javax.swing.JTextField();
        clearFindDexComButton = new javax.swing.JButton();
        claimDexcomButton = new javax.swing.JButton();
        ReleaseDexcom = new javax.swing.JButton();
        DebugTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        debugPaneRaw = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        clearDebugButton = new javax.swing.JButton();
        gcButton = new javax.swing.JButton();
        showMemButton = new javax.swing.JButton();
        wasteBytesButton = new javax.swing.JButton();
        wasteBytesTextField = new javax.swing.JTextField();
        freeWastedBytesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        findDexComButton.setText("Find Dexcom");
        findDexComButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findDexComButtonActionPerformed(evt);
            }
        });

        findDexcomPaneRaw.setBackground(new java.awt.Color(0, 0, 0));
        findDexcomPaneRaw.setFont(new java.awt.Font("Monospaced", 1, 14));
        findDexcomPaneRaw.setForeground(new java.awt.Color(0, 255, 0));
        jScrollPane1.setViewportView(findDexcomPaneRaw);

        jLabel2.setText("USB Device");

        usbDeviceTextField.setEditable(false);
        usbDeviceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usbDeviceTextFieldActionPerformed(evt);
            }
        });

        clearFindDexComButton.setText("Clear Messages");
        clearFindDexComButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFindDexComButtonActionPerformed(evt);
            }
        });

        claimDexcomButton.setText("Claim Dexcom");
        claimDexcomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claimDexcomButtonActionPerformed(evt);
            }
        });

        ReleaseDexcom.setText("Release Dexcom");
        ReleaseDexcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReleaseDexcomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout usbTabLayout = new javax.swing.GroupLayout(usbTab);
        usbTab.setLayout(usbTabLayout);
        usbTabLayout.setHorizontalGroup(
            usbTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usbTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usbTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
                    .addGroup(usbTabLayout.createSequentialGroup()
                        .addGroup(usbTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(findDexComButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearFindDexComButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(usbTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ReleaseDexcom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(claimDexcomButton, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usbDeviceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)))
                .addContainerGap())
        );
        usbTabLayout.setVerticalGroup(
            usbTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usbTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usbTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findDexComButton)
                    .addComponent(jLabel2)
                    .addComponent(usbDeviceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(claimDexcomButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usbTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearFindDexComButton)
                    .addComponent(ReleaseDexcom))
                .addGap(274, 274, 274))
        );

        jTabbedPane1.addTab("Usb", usbTab);

        debugPaneRaw.setBackground(new java.awt.Color(0, 0, 0));
        debugPaneRaw.setFont(new java.awt.Font("Monospaced", 1, 14));
        debugPaneRaw.setForeground(new java.awt.Color(0, 255, 0));
        jScrollPane2.setViewportView(debugPaneRaw);

        jLabel3.setText("Debug Messages");

        clearDebugButton.setText("Clear Debug");
        clearDebugButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDebugButtonActionPerformed(evt);
            }
        });

        gcButton.setText("Invoke Garbage Collection");
        gcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gcButtonActionPerformed(evt);
            }
        });

        showMemButton.setText("Display Memory");
        showMemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMemButtonActionPerformed(evt);
            }
        });

        wasteBytesButton.setText("Waste Bytes");
        wasteBytesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wasteBytesButtonActionPerformed(evt);
            }
        });

        wasteBytesTextField.setText("0");

        freeWastedBytesButton.setText("Free Wasted Bytes");
        freeWastedBytesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freeWastedBytesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DebugTabLayout = new javax.swing.GroupLayout(DebugTab);
        DebugTab.setLayout(DebugTabLayout);
        DebugTabLayout.setHorizontalGroup(
            DebugTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DebugTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DebugTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DebugTabLayout.createSequentialGroup()
                        .addGroup(DebugTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
                            .addGroup(DebugTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(showMemButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gcButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearDebugButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(freeWastedBytesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(DebugTabLayout.createSequentialGroup()
                        .addComponent(wasteBytesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wasteBytesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(829, 829, 829))))
        );
        DebugTabLayout.setVerticalGroup(
            DebugTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DebugTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearDebugButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gcButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showMemButton)
                .addGap(4, 4, 4)
                .addComponent(freeWastedBytesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DebugTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wasteBytesButton)
                    .addComponent(wasteBytesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Debug", DebugTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findDexComButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findDexComButtonActionPerformed
        try {
            fdx.greenWrite("\n");
            fdx.greenWrite("Searching for dexcom\n");
            try {
                List<UsbDeviceHub> devices = UsbUtils.listDevicesRecursively(UsbUtils.getRootHub());
                int nDevices = devices.size();
                for (int i = 0; i < nDevices; i++) {
                    fdx.greenWrite("usbDevice[%2d]=\"%s\"\n", i, devices.get(i).toString());
                }
            } catch (DexComNotFoundException ex) {
                fdx.redWrite("Error unable to find Dexcom\n");
                dbg.redWrite("Error unable to find Dexcom\n");
                dbg.writeException(ex);
                dexcom = null;
                usbDeviceTextField.setText("");
                return;
            }
            UsbDeviceHub dexDev = UsbUtils.findDexCom();
            dexcom = new DexComConnection(dexDev, fdx);
            fdx.greenWrite("Dexcom found\n%s\n", dexcom.toString());
            usbDeviceTextField.setText(dexcom.toString());
        } catch (DexComNotFoundException ex) {
            dbg.writeException(ex);
        }
    }//GEN-LAST:event_findDexComButtonActionPerformed

    private void usbDeviceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usbDeviceTextFieldActionPerformed
    }//GEN-LAST:event_usbDeviceTextFieldActionPerformed

    private void clearFindDexComButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFindDexComButtonActionPerformed
        fdx.clear();
    }//GEN-LAST:event_clearFindDexComButtonActionPerformed

    private void showMemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMemButtonActionPerformed
        long wbSize = 0;
        int nEntries;
        int i;
        String memory = Debug.showMem();
        dbg.greenWrite(memory);
        nEntries = wastedBytes.size();
        for (i = 0; i < nEntries; i++) {
            wbSize += wastedBytes.get(i).size();
        }
        dbg.greenWrite("wasted Bytes is %d\n", wbSize);
    }//GEN-LAST:event_showMemButtonActionPerformed

    private void wasteBytesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wasteBytesButtonActionPerformed
        int nBytes = 0;
        try {
            nBytes = Integer.parseInt(wasteBytesTextField.getText());
        } catch (NumberFormatException ex) {
            dbg.redWrite("Error converting %s to integer\n", wasteBytesTextField.getText());
            dbg.writeException(ex);
        }
        dbg.greenWrite("Wasted another %d bytes\n", nBytes);
        wastedBytes.add(new ByteWaster(nBytes));
    }//GEN-LAST:event_wasteBytesButtonActionPerformed

    private void clearDebugButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDebugButtonActionPerformed
        dbg.clear();
    }//GEN-LAST:event_clearDebugButtonActionPerformed

    private void gcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gcButtonActionPerformed
        dbg.greenWrite("Invoking garbage collector\n");
        Debug.gc();
    }//GEN-LAST:event_gcButtonActionPerformed

    private void freeWastedBytesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freeWastedBytesButtonActionPerformed
        long wbSize = 0;
        int i;
        int nEntries = wastedBytes.size();
        for (i = 0; i < nEntries; i++) {
            wbSize += wastedBytes.get(i).size();
        }
        dbg.greenWrite("Freeing %d bytes\n", wbSize);
        wastedBytes = new ArrayList<ByteWaster>();
    }//GEN-LAST:event_freeWastedBytesButtonActionPerformed

    private void claimDexcomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claimDexcomButtonActionPerformed
        try {
            dexcom.claimInterfacesAndSetEndpointsWithPipes();
        } catch (DexComException ex) {
            dbg.writeException(ex);
        }
    }//GEN-LAST:event_claimDexcomButtonActionPerformed

    private void ReleaseDexcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReleaseDexcomActionPerformed
        try {
            dexcom.releaseInterfaces();
        } catch (DexComException ex) {
            dbg.writeException(ex);
        }
    }//GEN-LAST:event_ReleaseDexcomActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DexcomFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DebugTab;
    private javax.swing.JButton ReleaseDexcom;
    private javax.swing.JButton claimDexcomButton;
    private javax.swing.JButton clearDebugButton;
    private javax.swing.JButton clearFindDexComButton;
    private javax.swing.JTextPane debugPaneRaw;
    private javax.swing.JButton findDexComButton;
    private javax.swing.JTextPane findDexcomPaneRaw;
    private javax.swing.JButton freeWastedBytesButton;
    private javax.swing.JButton gcButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton showMemButton;
    private javax.swing.JTextField usbDeviceTextField;
    private javax.swing.JPanel usbTab;
    private javax.swing.JButton wasteBytesButton;
    private javax.swing.JTextField wasteBytesTextField;
    // End of variables declaration//GEN-END:variables
    private ColoredTextPane fdx;
    private ColoredTextPane dbg;
    private List<ByteWaster> wastedBytes;
    private DexComConnection dexcom;
}
