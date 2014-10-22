package org.cgarza.exp.dexcom;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.usb.UsbClaimException;
import javax.usb.UsbConfiguration;
import javax.usb.UsbDisconnectedException;
import javax.usb.UsbEndpoint;
import javax.usb.UsbException;
import javax.usb.UsbInterface;
import javax.usb.UsbNotActiveException;
import javax.usb.UsbPipe;
import org.cgarza.exp.dexcom.exceptions.DexComException;
import org.cgarza.exp.utils.DetachKernelDriverUsbPolicy;

public class DexComConnection {

    private UsbDeviceHub device;
    private UsbConfiguration config;
    private UsbInterface controlIface;
    private UsbInterface dataIface;
    private UsbEndpoint controlEndpoint;
    private UsbEndpoint dataEndpoint;
    private UsbPipe controlPipe;
    private UsbPipe dataPipe;
    private PrintfInterface printfImpl;

    public DexComConnection(UsbDeviceHub dev, PrintfInterface printfImpl) {
        this.device = dev;
        config = dev.getUsbDevice().getActiveUsbConfiguration();
        controlIface = config.getUsbInterface((byte) 0);
        dataIface = config.getUsbInterface((byte) 1);
        this.printfImpl = printfImpl;
    }

    public void releaseInterfaces() throws DexComException {
        if (controlIface.isClaimed()) {
            try {
                controlIface.release();
                printfImpl.printf("control Interface released\n");
            } catch (UsbClaimException ex) {
                throw new DexComException(ex);
            } catch (UsbException ex) {
                throw new DexComException(ex);
            } catch (UsbNotActiveException ex) {
                throw new DexComException(ex);
            } catch (UsbDisconnectedException ex) {
                throw new DexComException(ex);
            }
        } else {
            printfImpl.printf("Control Interface already released\n");
        }

        if (dataIface.isClaimed()) {
            try {
                dataIface.release();
                printfImpl.printf("data Interface released\n");
            } catch (UsbClaimException ex) {
                throw new DexComException(ex);
            } catch (UsbException ex) {
                throw new DexComException(ex);
            } catch (UsbNotActiveException ex) {
                throw new DexComException(ex);
            } catch (UsbDisconnectedException ex) {
                throw new DexComException(ex);
            }
        } else {
            printfImpl.printf("data interface already released\n");
        }
    }

    public void claimInterfacesAndSetEndpointsWithPipes() throws DexComException {
        if (!controlIface.isClaimed()) {
            try {
                controlIface.claim(new DetachKernelDriverUsbPolicy());
                printfImpl.printf("found %d endpoints on controlInterface\n", controlIface.getUsbEndpoints().size());
                controlEndpoint = controlIface.getUsbEndpoint((byte) 0);
            } catch (UsbClaimException ex) {
                throw new DexComException(ex);
            } catch (UsbException ex) {
                throw new DexComException(ex);
            } catch (UsbNotActiveException ex) {
                throw new DexComException(ex);
            } catch (UsbDisconnectedException ex) {
                throw new DexComException(ex);
            }
        } else {
            printfImpl.printf("ControlInterface already claimed\n");
        }
        if (!dataIface.isClaimed()) {
            try {
                dataIface.claim(new DetachKernelDriverUsbPolicy());
                printfImpl.printf("found %d endpoints on data Interface\n", controlIface.getUsbEndpoints().size());
                dataEndpoint = dataIface.getUsbEndpoint((byte) 1);
            } catch (UsbClaimException ex) {
                throw new DexComException(ex);
            } catch (UsbException ex) {
                throw new DexComException(ex);
            } catch (UsbNotActiveException ex) {
                throw new DexComException(ex);
            } catch (UsbDisconnectedException ex) {
                throw new DexComException(ex);
            }
        } else {
            printfImpl.printf("DataInterface already claimed\n");
        }
    }

    public UsbDeviceHub getDevice() {
        return device;
    }

    public void setDevice(UsbDeviceHub device) {
        this.device = device;
    }

    public UsbConfiguration getConfig() {
        return config;
    }

    public void setConfig(UsbConfiguration config) {
        this.config = config;
    }

    public UsbInterface getControlIface() {
        return controlIface;
    }

    public void setControlIface(UsbInterface controlIface) {
        this.controlIface = controlIface;
    }

    public UsbInterface getDataIface() {
        return dataIface;
    }

    public void setDataIface(UsbInterface dataIface) {
        this.dataIface = dataIface;
    }

    public UsbEndpoint getControlEndpoint() {
        return controlEndpoint;
    }

    public void setControlEndpoint(UsbEndpoint controlEndpoint) {
        this.controlEndpoint = controlEndpoint;
    }

    public UsbEndpoint getDataEndpoint() {
        return dataEndpoint;
    }

    public void setDataEndpoint(UsbEndpoint dataEndpoint) {
        this.dataEndpoint = dataEndpoint;
    }

    public UsbPipe getControlPipe() {
        return controlPipe;
    }

    public void setControlPipe(UsbPipe controlPipe) {
        this.controlPipe = controlPipe;
    }

    public UsbPipe getDataPipe() {
        return dataPipe;
    }

    public void setDataPipe(UsbPipe dataPipe) {
        this.dataPipe = dataPipe;
    }

    public PrintfInterface getPrintfImpl() {
        return printfImpl;
    }

    public void setPrintfImpl(PrintfInterface printfImpl) {
        this.printfImpl = printfImpl;
    }
}
