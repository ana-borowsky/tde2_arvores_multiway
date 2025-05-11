public class Node {
    private int capacidade;
    private int numeroDePontos;
    private boolean dividido;
    private Ponto[] pontos;
    private Quadrante area;
    private Node norteOeste;
    private Node norteLeste;
    private Node sulOeste;
    private Node sulLeste;

    public Node(Quadrante area, int capacidade) {
        this.area = area;
        this.capacidade = capacidade;
        this.pontos = new Ponto[capacidade];
        this.dividido = false;
        this.numeroDePontos = 0;
    }

    public void dividir() {
        int x = area.getPosicaoX();
        int y = area.getPosicaoY();
        int altura = area.getAltura();
        int largura = area.getLargura();
        int novaLargura = largura / 2;
        int novaAltura = altura / 2;

        Quadrante no = new Quadrante(x - novaLargura, y + novaAltura, novaLargura, novaAltura);
        Quadrante nl = new Quadrante(x + novaLargura, y + novaAltura, novaLargura, novaAltura);
        Quadrante so = new Quadrante(x - novaLargura, y - novaAltura, novaLargura, novaAltura);
        Quadrante sl = new Quadrante(x + novaLargura, y - novaAltura, novaLargura, novaAltura);

        norteOeste = new Node(no, capacidade);
        norteLeste = new Node(nl, capacidade);
        sulOeste = new Node(so, capacidade);
        sulLeste = new Node(sl, capacidade);

        dividido = true;
    }

    public boolean insere(Ponto ponto) {
        if (!area.contem(ponto)) {
            return false;
        }

        if (numeroDePontos < capacidade && !dividido) {
            pontos[numeroDePontos++] = ponto;
            return true;
        }

        if (!dividido) {
            dividir();
            for (int i = 0; i < numeroDePontos; i++) {
                Ponto p = pontos[i];
                if (norteOeste.area.contem(p)) {
                    norteOeste.insere(p);
                } else if (norteLeste.area.contem(p)) {
                    norteLeste.insere(p);
                } else if (sulOeste.area.contem(p)) {
                    sulOeste.insere(p);
                } else {
                    sulLeste.insere(p);
                }
            }
            pontos = null;
        }

        if (norteOeste.area.contem(ponto)) {
            return norteOeste.insere(ponto);
        } else if (norteLeste.area.contem(ponto)) {
            return norteLeste.insere(ponto);
        } else if (sulOeste.area.contem(ponto)) {
            return sulOeste.insere(ponto);
        } else {
            return sulLeste.insere(ponto);
        }
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getNumeroDePontos() {
        return numeroDePontos;
    }

    public boolean isDividido() {
        return dividido;
    }

    public Ponto[] getPontos() {
        return pontos;
    }

    public Quadrante getArea() {
        return area;
    }

    public Node getNorteOeste() {
        return norteOeste;
    }

    public Node getNorteLeste() {
        return norteLeste;
    }

    public Node getSulOeste() {
        return sulOeste;
    }

    public Node getSulLeste() {
        return sulLeste;
    }
}
