public class Node {
    private int capacidade;
    private int numeroDePontos;
    private boolean dividido;
    private Ponto[] pontos;
    private Quadrante area;
    private Node noroeste;
    private Node nordeste;
    private Node sudoeste;
    private Node sudeste;

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
        Quadrante ne = new Quadrante(x + novaLargura, y + novaAltura, novaLargura, novaAltura);
        Quadrante so = new Quadrante(x - novaLargura, y - novaAltura, novaLargura, novaAltura);
        Quadrante se = new Quadrante(x + novaLargura, y - novaAltura, novaLargura, novaAltura);

        noroeste = new Node(no, capacidade);
        nordeste = new Node(ne, capacidade);
        sudoeste = new Node(so, capacidade);
        sudeste = new Node(se, capacidade);

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
                if (noroeste.area.contem(p)) {
                	noroeste.insere(p);
                } else if (nordeste.area.contem(p)) {
                	nordeste.insere(p);
                } else if (sudoeste.area.contem(p)) {
                	sudoeste.insere(p);
                } else {
                	sudeste.insere(p);
                }
            }
            pontos = null;
        }

        if (noroeste.area.contem(ponto)) {
            return noroeste.insere(ponto);
        } else if (nordeste.area.contem(ponto)) {
            return nordeste.insere(ponto);
        } else if (sudoeste.area.contem(ponto)) {
            return sudoeste.insere(ponto);
        } else {
            return sudeste.insere(ponto);
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

    public Node getNoroeste() {
        return noroeste;
    }

    public Node getNordeste() {
        return nordeste;
    }

    public Node getSudoeste() {
        return sudoeste;
    }

    public Node getSudeste() {
        return sudeste;
    }
}
