public class main {
    public static void main(String[] args) {
        AppGrafo g = new AppGrafo("G1.txt");
        System.out.println(g.recorridoAmplitud(g.getG(),1));
    }
}
