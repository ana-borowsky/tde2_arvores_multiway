public class Quadrante {
    private float posicaoX;
    private float posicaoY;
    private float largura;
    private float altura;

    public Quadrante(float posicaoX, float posicaoY, float largura, float altura) {
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

    public float getPosicaoX() {
        return posicaoX;
    }

    public float getPosicaoY() {
        return posicaoY;
    }

    public float getLargura() {
        return largura;
    }

    public float getAltura() {
        return altura;
    }
}
