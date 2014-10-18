package org.cgarza.exp.dexcom;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbException;
import javax.usb.UsbHub;

public class UsbDeviceHub {

    private UsbHub hub;
    private UsbDevice usbDevice;

    public UsbDeviceHub(UsbHub hub, UsbDevice device) {
        this.hub = hub;
        this.usbDevice = device;
    }

    @Override
    public String toString() {
        UsbDeviceDescriptor desc = usbDevice.getUsbDeviceDescriptor();
        String vendorId = StaticUtils.toHex(desc.idVendor());
        String productId = StaticUtils.toHex(desc.idProduct());
        String manufactoringId = "UNKNOWN";
        String productString = "UNKNOWN";
        try {
            manufactoringId = usbDevice.getManufacturerString();
        } catch (UsbException ex) {
        } catch (UnsupportedEncodingException ex) {
        } catch (UsbDisconnectedException ex) {
        }

        try {
            productString = usbDevice.getProductString();
        } catch (UsbException ex) {
        } catch (UnsupportedEncodingException ex) {
        } catch (UsbDisconnectedException ex) {
        }
        boolean isHub = usbDevice.isUsbHub();
        return "{ vendorId=" + vendorId + ", productId=" + productId
                + ", manufacture=" + manufactoringId + ", product="
                + productString + ", isHub=" + isHub + "}";
    }

    public static List<UsbDeviceHub> listDevicesRecursively(UsbHub root) {
        int i;
        int nDevices;
        UsbDevice currdev;
        UsbHub currHub;
        List<UsbDevice> devs;
        List<UsbDeviceHub> devList = new ArrayList<UsbDeviceHub>();
        devs = root.getAttachedUsbDevices();
        nDevices = devs.size();
        for (i = 0; i < nDevices; i++) {
            currdev = devs.get(i);
            devList.add(new UsbDeviceHub(root, currdev));
            if (currdev.isUsbHub()) {
                devList.addAll(listDevicesRecursively((UsbHub) currdev));
            }
        }
        return devList;
    }

    public UsbHub getHub() {
        return hub;
    }

    public void setHub(UsbHub hub) {
        this.hub = hub;
    }

    public UsbDevice getUsbDevice() {
        return usbDevice;
    }

    public void setUsbDevice(UsbDevice usbDevice) {
        this.usbDevice = usbDevice;
    }
}
