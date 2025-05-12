import java.util.Random;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame grafico = new JFrame("Plotagem da arvore quad");
            grafico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            grafico.setSize(500, 500);

            Quadrante area = new Quadrante(0, 0, 200, 200);
            Node node = new Node(area, 3);

            Random random = new Random();
            for (int i = 0; i < 1; i++) {
            	Ponto ponto = new Ponto(
            		    random.nextInt(400) - 200,
            		    random.nextInt(400) - 200
            		);
                System.out.println(ponto.getPosicaoX());
                System.out.println(ponto.getPosicaoY() + "\n");
                node.insere(ponto);
            }
            Ponto ponto = new Ponto( 4, 4);
            node.insere(ponto);
//            System.out.println(ponto.getPosicaoX());
//            System.out.println(ponto.getPosicaoY() + "\n");
//            node.remove(node, ponto);


            Grafico desenho = new Grafico(node);
            grafico.add(desenho);
            grafico.setVisible(true);
        });
    }
}
