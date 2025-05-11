import javax.swing.*;
import java.awt.*;

public class Grafico extends JPanel {
    private final Node node;

    public Grafico(Node tree) {
        this.node = tree;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;

        graphics2D.translate(centroX, centroY);
        graphics2D.scale(1, -1);

        if(node != null){
            desenhaArvore(graphics2D, node); // error
        }
    }

    public void desenhaArvore(Graphics2D graphics2D, Node node) {
        if (node == null) return;

        graphics2D.setColor(Color.green);
        Quadrante area = node.getArea();

        graphics2D.drawRect(
                (int) (area.getPosicaoX() - area.getLargura()),
                (int) (area.getPosicaoY() - area.getAltura()),
                (int) (area.getLargura() * 2),
                (int) (area.getAltura() * 2)
        );

        graphics2D.setColor(Color.MAGENTA);
        if ( node.getPontos() != null) {
            Ponto[] listaDePontos = node.getPontos();
            for (Ponto p : listaDePontos) {
                if(p != null){
                    graphics2D.fillOval(
                            (int)p.getPosicaoX() - 2,
                            (int)p.getPosicaoY() - 2,
                            6,
                            6);
                }
            }
        }
        if (node.isDividido()) {
            desenhaArvore(graphics2D, node.getNorteOeste());
            desenhaArvore(graphics2D, node.getNorteLeste());
            desenhaArvore(graphics2D, node.getSulOeste());
            desenhaArvore(graphics2D, node.getSulLeste());
        }
    }

}
