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
                if (G.costo(nodoactual,j) != 0 && G.costo(nodoactual,j) != G.INF ) {
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
        ArrayList<Integer> nodos = new ArrayList<>();
        nodos.add(u);
        int nodoactual = 0, i = 0;
        Boolean flag;
        while (i < nodos.size()) {
            nodoactual = nodos.get(i);
            for (int j = 1;j <= G.vertices() ; j++ ) {
                flag = true;
                if (G.costo(nodoactual,j) != 0 && G.costo(nodoactual,j) != G.INF ) {
                    for (int k = 0;k < nodos.size() ; k++ ){
                        if (j == nodos.get(k)){
                            flag = false;
                        }
                    }
                    if (flag){
                        nodos.add(j);
                        nodoactual = j;
                        j = 0;
                    }
                }
            }
            i++;
        }
        return nodos.toString();
    }

    public String dijkstra(Grafo G ,int u,int v){
        /*if (u>0 || u<=G.vertices() || v<=G.vertices() || v>0) {
            return "Vertices fuera de los parametros";
        }*/
        double menorDistancia = G.INF;
        int nodoactual = u;
        int siguienteNodo = u;
        double [] distancia = new double[G.vertices()];
        Boolean [] Recorrido = new Boolean[G.vertices()];
        ArrayList<Integer> visitas = new ArrayList<>();
        visitas.add(u);
        distancia[u-1] = 0;
        Recorrido[u-1] = true;
        for (int i = 0; i < G.vertices() ; i++ ) {
            if (i != u-1) {
                distancia[i] = G.INF;
                Recorrido[i] = false;
            }
        }
        Boolean flag = true;
        while (!Recorrido[v-1] && (visitas.size() > 0)) {
            menorDistancia = G.INF;
            nodoactual = siguienteNodo;
            for (int i = 1; i <= G.vertices() ; i++ ) {
                if (G.costo(nodoactual,i) != 0 && G.costo(nodoactual,i) != G.INF && !Recorrido[i-1] ) {
                    if (distancia[i-1] >= (G.costo(nodoactual,i)+distancia[nodoactual-1])) {
                        distancia[i-1] = G.costo(nodoactual,i)+distancia[nodoactual-1];
                        if (distancia[i-1]<menorDistancia) {
                            siguienteNodo = i;
                            menorDistancia = distancia[i-1];
                        }
                    }
                }
            }
            if (siguienteNodo == nodoactual) {
                visitas.remove((visitas.size()-1));
                if (visitas.size() > 0) {
                    siguienteNodo = visitas.get((visitas.size()-1));
                }
            }else{
                visitas.add(siguienteNodo);
                Recorrido[siguienteNodo-1] = true;
            }
        }
        if (visitas.size() == 0 ) {
            return "Desde "+u+" no se encontro una ruta al Nodo: "+v;
        }
        String Ret = "Recorrido mas corto de "+u+" a "+v+"\n";
        for (int i = 0; i < (visitas.size()-1) ; i++ ) {
            Ret += "El "+(i+1)+" movimiento [ "+visitas.get(i)+" -> "+visitas.get(1+i)+"] Con Costo de: "+distancia[visitas.get(1+i)-1]+"\n";
        }
        return Ret;
    }

    public Grafo getG() {
        return G;
    }

    public void setG(Grafo G) {
        this.G = G;
    }






}
