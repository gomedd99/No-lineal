public class main {
    public static void main(String[] args) {
        AppGrafo g = new AppGrafo("g_highschool.txt");
        System.out.println(g.getG().aCadena());
        System.out.println(g.recorridoProfundidad(g.getG(),1));

    }
}
