public class main {
    public static void main(String[] args) {
        AppGrafo g = new AppGrafo("G1.txt");
        System.out.println(g.recorridoProfundidad(g.getG(),1));

    }
}
