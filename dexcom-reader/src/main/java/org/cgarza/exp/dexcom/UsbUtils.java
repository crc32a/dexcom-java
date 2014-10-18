package org.cgarza.exp.dexcom;

import java.util.List;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbHub;
import org.cgarza.exp.dexcom.exceptions.DexComNotFoundException;

public class UsbUtils {
    public static UsbDeviceHub findDexCom(UsbHub root) throws DexComNotFoundException{
        int i;
        UsbDeviceHub dexcom = null;
        List<UsbDeviceHub> devs = UsbDeviceHub.listDevicesRecursively(root);
        int nDevices = devs.size();
        for(i=0;i<nDevices;i++){
            UsbDevice dev = devs.get(i).getUsbDevice();
            UsbDeviceDescriptor desc = dev.getUsbDeviceDescriptor();
            short vendorId = desc.idVendor();
            short productId = desc.idProduct();
            if(vendorId == Constants.VENDOR_ID && productId == Constants.PRODUCT_ID){
                return devs.get(i);
            }
        }
        throw new DexComNotFoundException();
    }
}
