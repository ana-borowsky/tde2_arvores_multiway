public class Quadrante {
    private int posicaoX;
    private int posicaoY;
    private int largura;
    private int altura;

    public Quadrante(int posicaoX, int posicaoY, int largura, int altura) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.largura = largura;
        this.altura = altura;
    }

    public boolean contem(Ponto ponto) {
        if (!(ponto.getPosicaoX() >= posicaoX - largura)){
            return false;
        }
        if (!(ponto.getPosicaoX() <= posicaoX + largura)){
            return false;
        }
        if (!(ponto.getPosicaoY() >= posicaoY - altura)){
            return false;
        }
        if (!(ponto.getPosicaoY() <= posicaoY + altura )){
            return false;
        }
        return true;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
}
