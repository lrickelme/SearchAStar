package org.example;

public class Node {
    public int valor;
    public int custoG;
    public int custoH;
    public Node pai;

    public Node(int valor, int custoG, int custoH, Node pai) {
        this.valor = valor;
        this.custoG = custoG;
        this.custoH = custoH;
        this.pai = pai;
    }

    public int getCustoF() {
        return custoG + custoH;
    }

}
