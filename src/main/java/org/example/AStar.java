package org.example;
import java.util.*;

public class AStar {
    private int valorInicial;
    private int valorObjetivo;
    private PriorityQueue<Node> conjuntoAberto;
    private Set<Integer> visitados;
    private int nosVisitados;

    public AStar(int valorInicial, int valorObjetivo) {
        this.valorInicial = valorInicial;
        this.valorObjetivo = valorObjetivo;
        this.conjuntoAberto = new PriorityQueue<>(Comparator.comparingInt(Node::getCustoF));
        this.visitados = new HashSet<>();
        this.nosVisitados = 0;
    }

    private int heuristica(int atual) {
        return Math.abs(valorObjetivo - atual);
    }

    public Map<String, Object> buscarCaminho() {
        Node noInicial = new Node(valorInicial, 0, heuristica(valorInicial), null);
        conjuntoAberto.add(noInicial);

        while (!conjuntoAberto.isEmpty()) {
            Node atual = conjuntoAberto.poll();
            nosVisitados++;

            if (atual.valor == valorObjetivo) {
                return reconstruirCaminho(atual);
            }

            visitados.add(atual.valor);

            for (int proximoValor : new int[]{atual.valor + 1, atual.valor * 2}) {
                if (!visitados.contains(proximoValor) && proximoValor <= valorObjetivo * 2) {
                    Node proximo = new Node(proximoValor, atual.custoG + 1, heuristica(proximoValor), atual);
                    conjuntoAberto.add(proximo);
                }
            }
        }

        return null;
    }

    private Map<String, Object> reconstruirCaminho(Node node) {
        List<Integer> caminho = new ArrayList<>();
        while (node != null) {
            caminho.add(node.valor);
            node = node.pai;
        }
        Collections.reverse(caminho);

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("caminho", caminho);
        resultado.put("nos_visitados", nosVisitados);
        resultado.put("custo_total", caminho.size() - 1);
        return resultado;
    }
}
