import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class AppGrafo {
    private Grafo G;
    //private int
    private String Re = " ";





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
        while (i < nodos.size()){
            nodoactual = nodos.get(i);
            for (int j = 1;j <= G.vertices()  ; j++ ) {
                flag = true;
                if (G.costo(nodoactual,j) != 0) {
                    for (int k = 0;k < nodos.size() ; k++ ){
                        if (j == nodos.get(k)){
                            flag = false;
                        }
                    }
                    if (flag){
                        nodos.add(j);
                    }
                }
            }
            i++;
        }
        Regreso += nodos.toString()+"}";
        return Regreso;
    }

    public String recorridoProfundidad(Grafo G,int u){
        System.out.println(u);
        Re += " "+u;
        System.out.println("this "+Re);
        int nodoExistente = 0, k = 1;
        for (int i = 1;i <= G.vertices() ;i++ ) {
            Boolean flag = true;
            nodoExistente = 0;
            k = 1;
            if (G.costo(u,i) != 0 ) {
                for (int j = 0;j < Re.length() ;j++ ) {
                    if(Re.codePointAt(j) != 32){
                        nodoExistente *= k;
                        nodoExistente += Character.getNumericValue(Re.charAt(j));
                        j *=10;
                    }else {
                        System.out.println(nodoExistente + " "+i);
                        if (nodoExistente == i) {
                            flag = false;
                            j = Re.length();
                        }
                    }
                }
                if (flag) {
                    return recorridoProfundidad(G,i);
                }
            }

        }
        return Re;

    }


	public Grafo getG() {
		return G;
	}

	public void setG(Grafo G) {
		this.G = G;
	}


}
