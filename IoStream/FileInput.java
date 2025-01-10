package IoStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInput {
    public void readFile() {
        FileReader fs = null;
        BufferedReader buffer = null;
        try {
            fs = new FileReader("d:/Vscode/java/IoStream/abc.txt");
            buffer = new BufferedReader(fs);
            while (buffer.ready()) {
                System.out.println(buffer.readLine());
            }
            fs.close();
            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wirteFile() {
        FileWriter fs = null;
        BufferedWriter buffer = null;
        try {
            fs = new FileWriter("d:/Vscode/java/IoStream/xyz.txt");
            buffer = new BufferedWriter(fs);
            buffer.write("This is written by filewriter meethod explicitly");
            System.out.println("File Write operation successfull");
            buffer.close();
            fs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void transeferFiletoFile(){
        FileReader fr = null;
        BufferedReader bufferRead = null;
        FileWriter fw = null;
        BufferedWriter bufferWrite = null;
        try{
            fr = new FileReader("d:/Vscode/java/IoStream/abc.txt");
            bufferRead = new BufferedReader(fr);
            fw = new FileWriter("d:/Vscode/java/IoStream/xyz.txt");
            bufferWrite = new BufferedWriter(fw);
            bufferRead.transferTo(bufferWrite);
            bufferRead.close();
            fr.close();
            bufferWrite.close();
            fw.close();
            System.out.println("Writing done... abc to xyz");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileInput obj = new FileInput();
        // obj.readFile();
        // obj.wirteFile();
        obj.transeferFiletoFile();
    }
}
