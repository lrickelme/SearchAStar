package org.example;

import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Digite o valor inicial: ");
        int valorInicial = sc1.nextInt();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Digite o valor objetivo: ");
        int valorObjetivo = sc2.nextInt();

        AStar algoritmo = new AStar(valorInicial, valorObjetivo);
        Map<String, Object> resultado = algoritmo.buscarCaminho();

        if (resultado != null) {
            System.out.println("Caminho: " + resultado.get("caminho"));
            System.out.println("Nós visitados: " + resultado.get("nos_visitados"));
            System.out.println("Custo total: " + resultado.get("custo_total"));
        } else {
            System.out.println("Caminho não encontrado.");
        }
    }
}