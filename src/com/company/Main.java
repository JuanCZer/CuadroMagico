package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    public static ArrayList<Integer> numerosUsados = new ArrayList<>(Arrays.asList(8, 4, 5, 6));

    public static void main(String[] args){

        int[][]  cuadro = {{8,0,4},{0,5,0},{6,0,0}};
        System.out.println("CUADRO SIN RESOLVER");
        imprimirArreglo(cuadro);
        System.out.println("\n");
        System.out.println("RESOLUCIÓN DE CUADRO MÁGICO");
        int[][] cuadroMagicoResuelto = computar(cuadro);

    }

    public static void imprimirArreglo(int[][] matriz){
        for (int x=0; x < matriz.length; x++){
            for (int y=0; y < matriz[x].length; y++) {
                System.out.print(" | " + matriz[x][y] + " | ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public static int heuristica(int n1, int n2){
       for(int i = 1; i <= 9; i++) {
           if (estaEnArray(i)) continue;

           int resultado1 = (n1 + n2 + i);
           int resultado2 = (resultado1 - 15);

           if (resultado2 == 0) {
                numerosUsados.add(i);
                return i;
           }

       }
        return 666;
    }

    public static boolean estaEnArray(int numero){
        return Arrays.asList(numerosUsados).contains(numero);
    }

    public static int[][] computar(int[][] cuadroResuelto){
        //int [][] cuadroResuelto = cuadro;
        int n1 = 0;
        int n2 = 0;
        int numeroMagico = 0;

        n1 = cuadroResuelto[0][0];
        n2 = cuadroResuelto[0][2];
        numeroMagico = heuristica(n1,n2);
        cuadroResuelto[0][1] = numeroMagico;

        imprimirArreglo(cuadroResuelto);


        n1 = cuadroResuelto[0][0];
        n2 = cuadroResuelto[1][1];
        numeroMagico = heuristica(n1,n2);
        cuadroResuelto[2][2] = numeroMagico;

        imprimirArreglo(cuadroResuelto);

        n1 = cuadroResuelto[0][0];
        n2 = cuadroResuelto[2][0];
        numeroMagico = heuristica(n1,n2);
        cuadroResuelto[1][0] = numeroMagico;

        imprimirArreglo(cuadroResuelto);

        n1 = cuadroResuelto[0][2];
        n2 = cuadroResuelto[2][2];
        numeroMagico = heuristica(n1,n2);
        cuadroResuelto[1][2] = numeroMagico;

        imprimirArreglo(cuadroResuelto);

        n1 = cuadroResuelto[2][0];
        n2 = cuadroResuelto[2][2];
        numeroMagico = heuristica(n1,n2);
        cuadroResuelto[2][1] = numeroMagico;
        System.out.println(numeroMagico + "-" + n1 + "-" + n2);
        imprimirArreglo(cuadroResuelto);

        return cuadroResuelto;
    }


}



