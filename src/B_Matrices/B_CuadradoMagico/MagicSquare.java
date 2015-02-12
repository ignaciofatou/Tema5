/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_Matrices.B_CuadradoMagico;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ignacio
 */
public class MagicSquare {
    
    //Objeto cuadrado sera una Matriz de Enteros
    private int[][] matrix;
    private int size;
    private final int TAMANHO_DEF = 4;
    ArrayList<Integer> numeros;
    ArrayList<Integer> numerosCopia;
    
    /**
     * Constructor de la Clase CuadradoMagico por defecto de tamaño 3x3
     */
    public MagicSquare(){
        this.size = TAMANHO_DEF;
        createMatrix(TAMANHO_DEF);        
    }
    /**
     * Constructor de la Clase CuadradoMagico
     * @param tam Tamaño del cuadrado
     */
    public MagicSquare(int tam){
        this.size = tam;
        createMatrix(tam);        
    }
    
    //Genera una lista todos los numeros consecutivamente
    private void generaNumeros(){
        //Calculamos el Numero mas Alto
        int numMax = TAMANHO_DEF * TAMANHO_DEF;
        numerosCopia = new ArrayList();
        
        //Guardamos todos los Numeros
        for (int x=0; x<numMax; x++){
            numerosCopia.add(x + 1);
        }
    }
    
    //Crea una Matriz de Numeros Aleatorios
    private void createMatrix(int tam){
        //Generamos una lista con los posibles Numeros
        generaNumeros();
        
        //
        int numCombinaciones = 0;
        
        do{
            matrix = new int[tam][tam];
            generateMagicSquare();
            numCombinaciones++;
            
            if ((numCombinaciones % 1000000) == 0.0)
                System.out.println("Combinacion: "+numCombinaciones);
            
        } while (!isCorrect());
        System.out.println("Total - Combinacion: "+numCombinaciones);
    }
    
    private void generateMagicSquare(){
        //Cremos el objeto de tipo Random para generar numeros Aleatorios
        Random numAleatorio = new Random();
        //numeros = duplicationArrayList(numerosCopia);
        numeros = (ArrayList<Integer>) numerosCopia.clone();
        
        for (int x=0; x<size; x++){
            for (int y=0; y<size; y++){
                matrix[x][y] = nexNumber(numAleatorio);
            }
        }     
    }
    
    private boolean generateMagicSquare2(){
        //Cremos el objeto de tipo Random para generar numeros Aleatorios
        Random numAleatorio = new Random();
        numeros = (ArrayList<Integer>) numerosCopia.clone();
        
        for (int x=0; x<TAMANHO_DEF;x++){
            for (int y=0; y<TAMANHO_DEF;y++){
                matrix[x][y] = nexNumber(numAleatorio);
            }
            
        }
        
        
        return true;
    }
    //private boolean validaFila(int numFila, int suma){
    //    for (int x=0; x<TAMANHO_DEF; x++){
            
    //    }
    //}
    
    
    private int nexNumber(Random random){

        int posicion = 0;
        Integer numero = 0;
        
        posicion = random.nextInt(numeros.size());
        numero = numeros.get(posicion);
        numeros.remove(posicion);
        return numero;
    }
    
    private boolean isCorrect(){

        //Comprobamos que todas las filas y Columnas sumen lo mismo
        int sumaFila    = 0;
        int sumaColumna = 0;
        int sumaDiagonalA = 0;
        int sumaDiagonalB = 0;
        int sumaA = 0;

        //Guardamos la primera suma
        for (int x=0; x<size; x++)
            sumaA = sumaA + matrix[x][0];
        
        //Recorremos la Matriz
        for (int x=0; x<size; x++){
            //Inicializamos variables
            sumaFila    = 0;
            sumaColumna = 0;

            //Recorremos la Matriz
            for (int y=0; y<size; y++){
                //Filas
                sumaFila    = sumaFila    + matrix[x][y];
                
                //Columnas
                sumaColumna = sumaColumna + matrix[y][x];
            }
            //Diagonales
            sumaDiagonalA = sumaDiagonalA + matrix[x][x];
            sumaDiagonalB = sumaDiagonalB + matrix[x][(size-1) - x];
            
            if ((sumaFila != sumaA) || (sumaFila != sumaColumna))
                return false;
        }
        //Comprobamos que la diagonal suma lo mismo
        if (sumaDiagonalA != sumaDiagonalB)
            return false;
        else if (sumaDiagonalA != sumaFila)
            return false;

        return true;
    }    
    
    public String toString(){
        
        String cadena = "";
        
        for (int x=0; x<size; x++){
            for (int y=0; y<size; y++){
                cadena = cadena + String.valueOf(matrix[x][y]) + " ";
            }
            cadena = cadena + "\n";
        }
        return cadena;
    }
}
