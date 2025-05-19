# Algoritmo A* em Java

Este projeto implementa o algoritmo **A\*** para encontrar o caminho mínimo entre um valor inicial e um valor objetivo, utilizando operações simples de incremento e multiplicação por 2 como possíveis movimentos.

---

## Descrição

O algoritmo busca o caminho ótimo para transformar um número inicial em um número objetivo, permitindo os seguintes passos:

- Incrementar o valor atual em 1.
- Multiplicar o valor atual por 2.

A heurística usada é a diferença absoluta entre o valor atual e o objetivo, o que garante uma busca informada eficiente.

---

## Estrutura do Projeto

- `AStar.java`  
  Implementação do algoritmo A*, incluindo o método para buscar o caminho e reconstruir a solução.

- `Node.java`  
  Representa um nó do grafo, armazenando o valor atual, custos e referência ao nó pai.

- `Main.java`  
  Interface simples para entrada do valor inicial e objetivo pelo terminal e exibição do resultado.

---

## Exemplo de uso


- Digite o valor inicial: 5

- Digite o valor objetivo: 12

- Caminho: [5, 10, 11, 12]

- Nós visitados: 4

- Custo total: 3
## Considerações

- O algoritmo limita a busca para valores até o dobro do valor objetivo para evitar expansão infinita.
- A implementação utiliza uma `PriorityQueue` para o conjunto aberto, garantindo que o nó com menor custo estimado seja expandido primeiro.