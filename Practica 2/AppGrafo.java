import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class AppGrafo {
    private Grafo G;
    //private int





	public AppGrafo(String nombre_archivo){
            try {
                File fileInput = new File(nombre_archivo);
                Scanner fileRead = new Scanner(fileInput);
                G = new Grafo(Integer.valueOf(fileRead.next()));
                while (fileRead.hasNextDouble()) {
                    G.agregarArco(Integer.valueOf(fileRead.next()),Integer.valueOf(fileRead.next()),Double.valueOf(fileRead.next()));
                }
                fileRead.close();
            }
            catch (IOException e) {
            }
	}

    public String recorridoAmplitud(Grafo G,int u){
        String Regreso = "{";
        ArrayList<Integer> nodos = new ArrayList<>();
        nodos.add(u);
        int nodoactual = 0;
        int i = 0;
        Boolean flag ;
        while (i < nodos.size()) {
            flag = true;
            nodoactual = nodos.get(i);
            System.out.println(nodos.size());
            for (int j = 1;j <= G.vertices()  ; j++ ) {
                if (G.costo(nodoactual,j) != 0) {
                    for (int k = 0;k < nodos.size() ; k++ )
                        if (j == nodos.get(k))
                            flag = false;
                    if (flag)
                        nodos.add(j);
                }
            }
        }
        Regreso += nodos.toString()+"}";
        return Regreso;
    }



	public Grafo getG() {
		return G;
	}

	public void setG(Grafo G) {
		this.G = G;
	}


}
