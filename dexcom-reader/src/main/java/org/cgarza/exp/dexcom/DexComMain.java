package org.cgarza.exp.dexcom;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbServices;
import org.cgarza.exp.dexcom.exceptions.DexComNotFoundException;

public class DexComMain {

    public static void main(String[] args) throws UsbException, UsbDisconnectedException, UnsupportedEncodingException {
        int i;
        UsbDeviceHub dexcom = null;
        UsbServices services = UsbHostManager.getUsbServices();
        UsbHub root = services.getRootUsbHub();
        List<UsbDeviceHub> devs = UsbDeviceHub.listDevicesRecursively(root);
        int nDevices = devs.size();
        System.out.printf("found %d devices\n", nDevices);
        for (i = 0; i < nDevices; i++) {
            UsbDeviceHub dev = devs.get(i);
            short vendorId = dev.getUsbDevice().getUsbDeviceDescriptor().idVendor();
            short productId = dev.getUsbDevice().getUsbDeviceDescriptor().idProduct();
            System.out.printf("usb[%3d] = %s", i, dev.toString());
            if (vendorId == Constants.VENDOR_ID && productId == Constants.PRODUCT_ID) {
                System.out.printf(" ****");
            }
            System.out.printf("\n");
        }
        System.out.printf("Searching for dexcom\n");
        try {
            dexcom = UsbUtils.findDexCom(root);
        } catch (DexComNotFoundException ex) {
            System.out.printf("DexCom not found\n");
            return;
        }
        String hubString = dexcom.getHub().toString();
        String serialNumber = dexcom.getUsbDevice().getSerialNumberString();
        System.out.printf("Dexcom found on hub %s\nSerialNumber=%s\n", hubString, serialNumber);
    }
}
