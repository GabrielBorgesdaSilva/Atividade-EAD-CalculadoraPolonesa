/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadoraempilhada;

/**
 *
 * @author gabri
 */

import java.util.Scanner;
import java.util.Stack;

public class CalculadoraEmpilhada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> pilhaDeNumeros = new Stack<>();
        
        System.out.println("=== CALCULADORA EMPILHADA (EDI) ===");
        System.out.println("Digite a expressao pos-fixa separada por espacos (Ex: 3 4 + 2 *):");
        String expressaoDigitada = scanner.nextLine();
        
        String[] elementos = expressaoDigitada.split(" ");
        
        for (int i = 0; i < elementos.length; i++) {
            String elementoAtual = elementos[i];
            
            if (elementoAtual.equals("+") || elementoAtual.equals("-") || elementoAtual.equals("*") || elementoAtual.equals("/")) {
                int segundoNumero = pilhaDeNumeros.pop();
                int primeiroNumero = pilhaDeNumeros.pop();
                int resultadoOperacao = 0;
                
                if (elementoAtual.equals("+")) {
                    resultadoOperacao = primeiroNumero + segundoNumero;
                } else if (elementoAtual.equals("-")) {
                    resultadoOperacao = primeiroNumero - segundoNumero;
                } else if (elementoAtual.equals("*")) {
                    resultadoOperacao = primeiroNumero * segundoNumero;
                } else if (elementoAtual.equals("/")) {
                    resultadoOperacao = primeiroNumero / segundoNumero;
                }
                
                pilhaDeNumeros.push(resultadoOperacao);
                
            } else {
                int numeroConvertido = Integer.parseInt(elementoAtual);
                pilhaDeNumeros.push(numeroConvertido);
            }
        }
        
        int resultadoFinal = pilhaDeNumeros.pop();
        
        System.out.println("\nResultado do Calculo: " + resultadoFinal);
        System.out.println("\nNotacoes:");
        System.out.println("Pos-fixa digitada: " + expressaoDigitada);
        
        scanner.close();
    }
}