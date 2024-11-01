/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.montes_alberto_estructura;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Martin Montes
 */
public class Montes_alberto_estructura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int option;
        int countReverse = 0, countPerfect = 0, countPrime = 0, countVoting = 0;

        do {
            // Mostrar el menú AMMM
            System.out.println("Menu:");
            System.out.println("1 - Palabra Alreves");
            System.out.println("2 - Numero Perfecto");
            System.out.println("3 - Primos");
            System.out.println("4 - Votaciones");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opcion: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (option) {
                case 1:
                    countReverse++;
                    // Ingresar palabra y mostrar al revés
                    System.out.print("Ingrese una palabra: ");
                    String palabra = scanner.nextLine();
                    String palabraAlReves = new StringBuilder(palabra).reverse().toString();
                    System.out.println("Palabra al reves: " + palabraAlReves);
                    break;
                    
                case 2:
                    countPerfect++;
                    // Comprobar si un número es perfecto
                    System.out.print("Ingrese un numero: ");
                    int numero = scanner.nextInt();
                    int sumaDivisores = 0;
                    for (int i = 1; i < numero; i++) {
                        if (numero % i == 0) {
                            sumaDivisores += i;
                        }
                    }
                    if (sumaDivisores == numero) {
                        System.out.println(numero + " es un numero perfecto.");
                    } else {
                        System.out.println(numero + " no es un numero perfecto.");
                    }
                    break;
                    
                case 3:
                    countPrime++;
                    // Generar número aleatorio y verificar si es primo
                    int numeroAleatorio = random.nextInt(100) + 1;
                    System.out.println("Numero aleatorio generado: " + numeroAleatorio);
                    boolean esPrimo = true;
                    int divisoresCount = 0;
                    String divisores = "";

                    for (int i = 1; i <= numeroAleatorio; i++) {
                        if (numeroAleatorio % i == 0) {
                            divisores += i + " ";
                            divisoresCount++;
                        }
                    }

                    if (divisoresCount == 2) {
                        System.out.println("El numero " + numeroAleatorio + " es primo.");
                    } else {
                        System.out.println("El numero " + numeroAleatorio + " no es primo.");
                    }
                    System.out.println("Divisores de " + numeroAleatorio + " son: " + divisores.trim());
                    break;
                    
                case 4:
                    countVoting++;
                    // Votación de planillas
                    System.out.print("Ingrese la cantidad de votantes: ");
                    int votantes = scanner.nextInt();
                    scanner.nextLine();  // Limpiar buffer
                    int azul = 0, rojo = 0, negro = 0, amarillo = 0, nulos = 0;

                    for (int i = 0; i < votantes; i++) {
                        System.out.print("Voto #" + (i + 1) + " (AZUL, ROJO, NEGRO, AMARILLO): ");
                        String voto = scanner.nextLine().toUpperCase();
                        
                        switch (voto) {
                            case "AZUL":
                                azul++;
                                break;
                            case "ROJO":
                                rojo++;
                                break;
                            case "NEGRO":
                                negro++;
                                break;
                            case "AMARILLO":
                                amarillo++;
                                break;
                            default:
                                nulos++;
                        }
                    }

                    // Calcular votos válidos y determinar ganador
                    int votosValidos = azul + rojo + negro + amarillo;
                    double porcentajeValidos = (double) votosValidos / votantes * 100;

                    if (porcentajeValidos >= 60) {
                        String ganador = "AZUL";
                        int maxVotos = azul;
                        
                        if (rojo > maxVotos) {
                            ganador = "ROJO";
                            maxVotos = rojo;
                        }
                        if (negro > maxVotos) {
                            ganador = "NEGRO";
                            maxVotos = negro;
                        }
                        if (amarillo > maxVotos) {
                            ganador = "AMARILLO";
                        }
                        
                        System.out.println("La planilla ganadora es: " + ganador);
                    } else {
                        System.out.println("VOTACIÓN FALLIDA");
                    }
                    break;
                    
                case 5:
                    // Opción de salida
                    System.out.println("Saliendo del programa...");
                    System.out.println("Resumen de visitas:");
                    System.out.println("1 - Palabra Alreves: " + countReverse);
                    System.out.println("2 - Numero Perfecto: " + countPerfect);
                    System.out.println("3 - Primos: " + countPrime);
                    System.out.println("4 - Votaciones: " + countVoting);
                    break;
                    
                default:
                    System.out.println("Opcion no válida. Intente de nuevo.");
            }
        } while (option != 5);

        scanner.close();
    }
}

