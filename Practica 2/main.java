public class main {
    public static void main(String[] args) {
        AppGrafo g = new AppGrafo("Prueba1.txt");
        //System.out.println(g.getG().aCadena());
        System.out.println(g.recorridoProfundidad(g.getG(),3));
        //System.out.println(g.dijkstra(g.getG(),1,5));

    }
}
