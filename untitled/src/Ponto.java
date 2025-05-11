public class Ponto {
    private int posicaoX;
    private int posicaoY;

    public Ponto(int xPosicao, int posicaoY) {
        this.posicaoX = xPosicao;
        this.posicaoY = posicaoY;
    }

    public double getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public double getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
}
