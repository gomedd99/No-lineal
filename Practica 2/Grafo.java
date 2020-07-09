public class Grafo {

    /**
     * Un valor muy grande que representa la ausencia de un arco
     */
    public static final double INF = Double.MAX_VALUE;

    /**
     * La matriz de ponderaciones
     */
    private double[][] costo;

    /**
     * El numero de vertices que contiene el Grafo
     */
    private int n;

    /**
     * El número de arcos que contiene el Grafo
     */
    private int arcos;


    /**
     * Crea un Grafo vacio con <code>numVertices</code>.
     *
     * @param numVertices El numero de vertices que contiene el Grafo.
     */
    public Grafo(int numVertices) {
        n = numVertices;
        arcos = 0;
        costo = new double[n][n];
        for (int i = 0; i < n; i++) {
            costo[i][i] = 0;
            for (int j = i+1; j < n; j++) {
                costo[i][j] = 0;
                costo[j][i] = 0;
            }
        }
    }


    /**
     * Verifica que <code>nodo</code> es un nodo válido.
     *
     * @param nodo El nodo que se va a verificar que es válido.
     * @return <code>true</code> si el <code>nodo</code> es válido,
     * <code>false</code> en caso contrario.
     */
    private boolean nodoValido(int nodo) {
        boolean valido = false;
        if ((nodo > 0) || (nodo <= n))
            valido = true;
        return valido;
    }


    /**
     * Agrega un arco que va del vértice <code>origen</code> al vertice
     * <code>destino</code> con un costo <code>costo</code>.
     *
     * @param origen El vértice origen del arco.
     * @param destino El vértice destino del arco.
     * @param costo El costo del arco.
     * @return <code>true</code> si el arco se pudo agregar y
     * <code>false</code> en caso contrario.
     */
    public boolean agregarArco(int origen, int destino, double costo) {
        boolean valido = false;
        if (nodoValido(origen) && nodoValido(destino)
                && (origen != destino) && (costo >= 0)) {

            // Si no existe el arco (origen,destino), se incrementa
            // la cuenta de arcos
            if (this.costo[origen - 1][destino - 1] == INF)
                arcos++;

            // Si el costo que se quiere asignar es INF, se decrementa
            // el numero de arcos
            if (costo == INF)
                arcos--;

            this.costo[origen - 1][destino - 1] = costo;
            valido = true;
        }
        return valido;
    }


    /**
     * Devuelve el costo del arco que va del vertice  <code>origen</code> al vertice
     * <code>destino</code>.
     *
     * @param origen El vertice origen del arco.
     * @param destino El vertice destino del arco.
     * @return El costo del arco que va del vertice <code>origen</code> al vertice
     * <code>destino</code>.
     */
    public double costo(int origen, int destino) {
        double costo = 0.0;
        if (nodoValido(origen) && nodoValido(destino))
            costo = this.costo[origen - 1][destino - 1];

        return costo;
    }


    /**
     * Devuelve el número de arcos contenidos en el Grafo.
     *
     * @return <code>arcos>/code>, el numero de arcos contenidos en el Grafo.
     */
    public int arcos() {
        return arcos;
    }


    /**
     * Devuelve el número de vértices contenidos en el Grafo.
     *
     * @return <code>n</code>, el numero de vértices contenidos en el Grafo.
     */
    public int vertices() {
        return n;
    }


    /**
     * Devuelve un <code>String</code> con el conjunto de vértices y el conjunto de arcos
     * que forman el Grafo.
     *
     * @return Un <code>String</code> que contiene el conjunto de vértices y el conjunto de
     * arcos que forman el Grafo.
     */
    public String aCadena() {
        String vertices = "V = {";
        String arcos = "A = {";
        for (int i = 1; i <= n; i++) {
            vertices += i;
            for (int j = 1; j <= n; j++) {
                if ((i != j) && (costo(i, j) < INF)) {
                    arcos += "(" + i + "," + j + "):" + costo(i, j) + ", ";
                }
            }
            if (i < n) {
                vertices += ", ";
            }
        }
        vertices += "}";
        arcos = arcos.substring(0, arcos.length() - 2) + "}";
        return vertices + "\n" + arcos;
    }
}
