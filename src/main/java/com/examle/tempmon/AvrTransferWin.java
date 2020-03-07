package com.examle.tempmon;

import java.nio.ByteBuffer;

import org.springframework.stereotype.Service;
import org.usb4java.DeviceHandle;
import org.usb4java.LibUsb;
import org.usb4java.LibUsbException;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;

@Service
@Component
public class AvrTransferWin
{

    /** The vendor ID of the */
    private static final short VENDOR_ID = 0x16c0;

    /** The vendor ID of the */
    private static final short PRODUCT_ID = 0x05df;

    /** The ADB interface number of the  */
    private static final byte INTERFACE = 0;

    /** The communication timeout in milliseconds. */
    private static final int TIMEOUT = 0;
    private static final byte _USB_ENDPOINT_IN = (byte)0x80;
    private static final byte _HID_SET_REPORT  = 0x09;
    private static final byte _HID_GET_REPORT  = 0x01;
    private static final byte GET_BYTE  = 2;
    double res;
    /**
     * Reads some data from the device.
     *
     * @param handle
     *            The device handle.
     * @return The read data.
     */
    @Async
    public void proxyread()throws InterruptedException{
        for (;;) {
            read();
            //if (model != null) model.addAttribute("temperature", res);
            Thread.sleep(1000);
        }
    }


    public void read()
    {
      //  for (;;)

            ByteBuffer buffer = ByteBuffer.allocateDirect(GET_BYTE);
            buffer.rewind();
            int result=0;
            while (result<=0) {
                result = LibUsb.controlTransfer(handle,
                        (byte) (LibUsb.REQUEST_TYPE_CLASS | LibUsb.RECIPIENT_INTERFACE | _USB_ENDPOINT_IN),
                        _HID_GET_REPORT,
                        (short) 256,
                        (short) 0, buffer, TIMEOUT);

                if (result < 0)
                   // throw new LibUsbException("Control transfer failed", result);
                    System.out.println(result + " " + "O/I bull&it" );
            }
            if (result != GET_BYTE)
                throw new RuntimeException("Not all data was received from device:" + result);
            System.out.println(result + " bytes read from device");
            byte[] data = new byte[GET_BYTE];
            buffer.rewind();
            for (int i = 0; i < GET_BYTE; i++) {
                data[i] = buffer.get();
            }
            //debug("Data received from device: "+YubikeyUtil.toHexString(data));
            byte r = data[1];
            byte mask_b1 = 0b00000001;
            byte mask_b2 = 0b00000010;
            byte mask_b3 = 0b00000100;
            byte mask_b4 = 0b00001000;
            int bit0 = r & mask_b1;
            int bit1 = (r & mask_b2) >> 1;
            int bit2 = (r & mask_b3) >> 2;
            int bit3 = (r & mask_b4) >> 3;
            double di = bit0 * (Math.pow(2, -4)) + bit1 * (Math.pow(2, -3)) + bit2 * (Math.pow(2, -2)) + bit3 * (Math.pow(2, -1));
            double ro = data[0];
            res = di + ro;
            System.out.println("t=" + res + "C" + "\u00B0");

            //if (model != null) model.addAttribute("temperature", res);
            //Thread.sleep(1000);
           // return res;
      //  }
    }
    /**
     * Main method.
     *
     * @param args
     *            Command-line arguments (Ignored)
     * @throws Exception
     *             When something goes wrong.
     */
    DeviceHandle handle;
    public  void opendiv() throws Exception {
        // Initialize the libusb context
        int result = LibUsb.init(null);
        if (result != LibUsb.SUCCESS) {
            throw new LibUsbException("Unable to initialize libusb", result);
        }

        // Open test device (V-USB)
        handle = LibUsb.openDeviceWithVidPid(null, VENDOR_ID, PRODUCT_ID);
        if (handle == null) {
            System.err.println("Test device not found.");
            System.exit(1);
        }
         String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {
            int r = LibUsb.detachKernelDriver(handle, INTERFACE);
            if (r != LibUsb.SUCCESS &&
                    r != LibUsb.ERROR_NOT_SUPPORTED &&
                    r != LibUsb.ERROR_NOT_FOUND) throw new LibUsbException("Unable to detach kernel     driver", r);
        }
        // Claim the ADB interface
        result = LibUsb.claimInterface(handle, INTERFACE);
        if (result != LibUsb.SUCCESS) {
            throw new LibUsbException("Unable to claim interface", result);
        }

    }
   // read(handle);
    public void closediv(){
        // Close the device
        LibUsb.close(handle);

        // Deinitialize the libusb context
        LibUsb.exit(null);
    }


}