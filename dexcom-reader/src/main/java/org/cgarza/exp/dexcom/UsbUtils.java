package org.cgarza.exp.dexcom;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbServices;
import org.cgarza.exp.dexcom.exceptions.DexComNotFoundException;

public class UsbUtils {

    private static String ROOT_HUB_ERROR = "Error getting root USB hub";

    public static UsbHub getRootHub() throws DexComNotFoundException {
        UsbServices services;
        UsbHub root;
        {
            try {
                services = UsbHostManager.getUsbServices();
                root = services.getRootUsbHub();
            } catch (UsbException ex) {
                throw new DexComNotFoundException(ROOT_HUB_ERROR, ex);
            } catch (SecurityException ex) {
                throw new DexComNotFoundException(ROOT_HUB_ERROR, ex);
            }
        }
        return root;
    }

    public static UsbDeviceHub findDexCom() throws DexComNotFoundException {
        UsbHub root;
        root = getRootHub();
        return findDexCom(root);
    }

    public static UsbDeviceHub findDexCom(UsbHub root) throws DexComNotFoundException {
        int i;
        UsbDeviceHub dexcom = null;
        List<UsbDeviceHub> devs = UsbDeviceHub.listDevicesRecursively(root);
        int nDevices = devs.size();
        for (i = 0; i < nDevices; i++) {
            UsbDevice dev = devs.get(i).getUsbDevice();
            UsbDeviceDescriptor desc = dev.getUsbDeviceDescriptor();
            short vendorId = desc.idVendor();
            short productId = desc.idProduct();
            if (vendorId == Constants.VENDOR_ID && productId == Constants.PRODUCT_ID) {
                return devs.get(i);
            }
        }
        throw new DexComNotFoundException();
    }
}
