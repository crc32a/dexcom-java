package org.cgarza.exp.utils;

import javax.usb.UsbInterface;
import javax.usb.UsbInterfacePolicy;

public class DetachKernelDriverUsbPolicy implements UsbInterfacePolicy{

    public DetachKernelDriverUsbPolicy() {
    }

    @Override
    public boolean forceClaim(UsbInterface ui) {
        return true;
    }

}
