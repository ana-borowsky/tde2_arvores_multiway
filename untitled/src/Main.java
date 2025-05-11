import java.util.Random;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame grafico = new JFrame("Plot da Arvore quad");
            grafico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            grafico.setSize(500, 500);

            Quadrante area = new Quadrante(0, 0, 200, 200);
            Node node = new Node(area, 3);

            Random random = new Random();
            for (int i = 0; i < 20; i++) {
            	Ponto ponto = new Ponto(
            		    random.nextInt(400) - 200,
            		    random.nextInt(400) - 200
            		);
                node.insere(ponto);
            }

            Grafico draw = new Grafico(node);
            grafico.add(draw);
            grafico.setVisible(true);
        });
    }
}
