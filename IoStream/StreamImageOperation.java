package IoStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamImageOperation {
    public void TransferImage(){
        try {
            FileInputStream FI = new FileInputStream("d:/Vscode/java/IoStream/image/test1.png");
            BufferedInputStream bufferI = new BufferedInputStream(FI);
            byte[] b = bufferI.readAllBytes();;
            // FileOutputStream FO = new FileOutputStream("d:/Vscode/java/IoStream/image/Testing_upload/test.txt");
            FileOutputStream FO = new FileOutputStream("d:/Vscode/java/IoStream/image/Testing_upload/TransfereDtest.txt");
            BufferedOutputStream bufferO = new BufferedOutputStream(FO);
            bufferO.write(b);
            bufferI.close();
            FI.close();
            bufferO.close();
            FO.close();
            System.out.println("Image transfer Successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        StreamImageOperation obj = new StreamImageOperation();
        obj.TransferImage();
    }
}
