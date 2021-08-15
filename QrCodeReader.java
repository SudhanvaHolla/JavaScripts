import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
import javax.imageio.ImageIO;  
import com.google.zxing.BinaryBitmap;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.MultiFormatReader;  
import com.google.zxing.NotFoundException;  
import com.google.zxing.Result;  
import com.google.zxing.WriterException;  
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;  
import com.google.zxing.common.HybridBinarizer;  
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;  
import java.awt.Desktop;
import java.io.*;
import java.net.URI;

public class QrCodeReader   
{   
    public static String readQRcode(String path, String charset, Map map) throws FileNotFoundException, IOException, NotFoundException  
    {  
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));  
        Result rslt = new MultiFormatReader().decode(binaryBitmap);  
        return rslt.getText();  
    }  
    public static void url(String a) throws Exception
    {
            Desktop desk = Desktop.getDesktop();
            desk.browse(new URI(a));
    }

    public static void main(String args[]) throws WriterException, IOException, NotFoundException, Exception
    {  
        String path = "C:\\Users\\crsho\\OneDrive\\Desktop\\QR5.png";  
        String charset = "UTF-8";  
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();   
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  
        System.out.println("Data stored in the QR Code is: \n"+ readQRcode(path, charset, hintMap));  
        String a = readQRcode(path, charset, hintMap);
        url(a);
    }	
}  