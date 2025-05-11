# 🌳 Árvore Quad
Atividade da disciplina Resolução de problemas estruturados em computação
Este projeto implementa uma **árvore Quad (quadtree)** para organização espacial de pontos em um plano bidimensional. A árvore quad é uma estrutura de dados hierárquica amplamente utilizada em áreas como:

- Indexação espacial
- Simulações físicas
- Processamento de imagens
- Jogos 2D
- Algoritmos de colisão

Além da estrutura lógica da árvore, o projeto inclui uma **visualização gráfica interativa em Java (Swing)**.

---
## Exemplo de Visualização

A tela exibida mostra:
- O espaço sendo subdividido conforme os pontos são inseridos.
- Cada quadrante representando uma região.
- Os pontos distribuídos graficamente no plano.

> **Obs.:** O centro da tela é o ponto (0,0), e os eixos foram invertidos para visualização cartesiana.

Plotagem gerada pelo programa:

![Image](https://github.com/user-attachments/assets/c6c319ba-0872-42cf-af47-5d36bd343a24)


## Estrutura do Projeto

### `Ponto.java`

Representa um ponto 2D com coordenadas X e Y.

- Atributos: `posicaoX`, `posicaoY`
- Métodos: getters, setters

---

### `Quadrante.java`

Define uma área retangular usada para verificar se um ponto está dentro de seus limites.

- Atributos: centro (`posicaoX`, `posicaoY`), dimensões (`largura`, `altura`)
- Método principal: `boolean contem(Ponto ponto)`

---

### `Node.java`

Implementa o nó da árvore Quad. Cada nó armazena um número limitado de pontos. Se exceder a capacidade, o nó se subdivide em 4 subnós.

- Atributos:
  - `pontos[]`: pontos armazenados no nó
  - `area`: região do espaço representada
  - `capacidade`: número máximo de pontos por nó
  - `dividido`: indica se o nó foi subdividido
  - Subnós: `noroeste`, `nordeste`, `sudoeste`, `sudeste`
- Métodos:
  - `boolean insere(Ponto ponto)`
  - `void dividir()`

---

### `Grafico.java`

Renderiza graficamente a árvore quad com seus quadrantes e pontos utilizando a biblioteca Swing.

- Herda de `JPanel`
- Desenha:
  - Quadrantes: em **verde**
  - Pontos: em **magenta**

---

### `Main.java`

Classe principal que inicia a aplicação gráfica.

- Cria uma janela `JFrame`
- Instancia a árvore com área de 400x400
- Gera 20 pontos aleatórios
- Insere os pontos na árvore
- Exibe a visualização gráfica da árvore gerada

---

## Como Executar

### Pré-requisitos

- Java 8 ou superior
- IDE como IntelliJ, Eclipse ou VS Code com suporte a Java

Execute a classe Main.
