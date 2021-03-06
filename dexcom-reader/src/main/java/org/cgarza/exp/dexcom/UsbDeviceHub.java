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
import org.cgarza.exp.utils.HexCoder;

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
        String vendorId = HexCoder.toHex(desc.idVendor());
        String productId = HexCoder.toHex(desc.idProduct());
        String manufactoringId = "UNKNOWN";
        String productString = "UNKNOWN";
        String serialNumber = "UNknOWN";
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
        try {
            serialNumber = usbDevice.getSerialNumberString();
        } catch (UsbException ex) {
        } catch (UnsupportedEncodingException ex) {
        } catch (UsbDisconnectedException ex) {
        }
        boolean isHub = usbDevice.isUsbHub();
        return "{ vendorId=" + vendorId + ", productId=" + productId
                + ", manufacture=" + manufactoringId + ", product="
                + productString + ", isHub=" + isHub +", serialNumber="
                + serialNumber + "}";
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
