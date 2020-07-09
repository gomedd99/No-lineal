import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.io.*;
public class lecturapruebas {
    public static void main(String[] args) throws FileNotFoundException,IOException {
        try {
            File fis = new File( "g_baywet.txt" );
            Scanner myReader = new Scanner(fis);
            Grafo gg = new Grafo(Integer.valueOf(myReader.next()));
            if (myReader.hasNextLine()) {
                do {
                    gg.agregarArco(Integer.valueOf(myReader.next()),Integer.valueOf(myReader.next()),Double.valueOf(myReader.next()));
                } while (myReader.hasNextDouble());
            }
            for (int i = 1;i <= 128 ;i++ ) {
                for (int j = 1 ; j <= 128 ;j++ ) {
                    System.out.println(i+" "+j+" "+gg.costo(i,j));
                }
            }
            //double data =Double.valueOf(myReader.next());
            //System.out.println(data);
            myReader.close();
        }
        catch (IOException e) {
            throw e;
        }
    }
}
