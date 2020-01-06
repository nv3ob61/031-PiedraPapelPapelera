/*
 * Copyright 2019 mon_mo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.app;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final String PACO = "---";
    public static final String MSG_ELIGE = "Elige un elemento [1 = Piedra, "
            + "2 = Papel, 3 = Papelera] ";
    public static final String MSG_APUESTA = "¿Cuánto quieres apostar? ";
    public static final String MSG_ERR = "ERROR: Valor introducido no válido";
    public static final String MSG_ERROP = "ERROR: Opción incorrecta";
    public static double euros;

    public final void launchApp() {
        euros = 25.00;

        muestraBanner();
        printf("Empiezas con %.2f€%n", euros);

        while (!(euros <= 0) || (euros >= 100)) {
            double apuesta = generaApuesta();
            println();
            int resp = eligeElemento();
            println();
            duerme();

            int maquina = juegaMaquina();
            println();
            duerme();

            euros = comparaElementos(maquina, resp, apuesta);

            println();
            duerme();
            printf("Balance actual: %.2f €%n%n", euros);
            duerme();
        }

        duerme();
        muestraBannerSal();
        duerme();
        duerme();

        if (euros <= 0.00) {
            println("HAS PERDIDO. Ninonino");
        } else {
            println("Tutututu. HAS GANADO!");
        }
    }

    public static double comparaElementos(int com, int choice, double apuesta) {
        if ((com == 1 && choice == 3) || (com == 2 && choice == 1)
                || (com == 3 && choice == 2)) {
            println(PACO);
            println("Has PERDIDO esta ronda");
            printf("Y pierdes %.2f € de tu apuesta.%n", apuesta);
            euros = euros - apuesta;
        } else if ((choice == 1 && com == 3) || (choice == 2 && com == 1)
                || (choice == 3 && com == 2)) {
            println(PACO);
            println("Has GANADO esta ronda");
            printf("Y ganas %.2f € de tu apuesta.%n", apuesta);
            euros = euros + (apuesta * 2);
        } else {
            println(PACO);
            println("Es un EMPATE!");
            printf("Tienes tu apuesta de %.2f € devuelta.%n", apuesta);
        }
        return euros;
    }

    public static int eligeElemento() {

        int choice = UtilesEntrada.leerEntero(MSG_ELIGE, MSG_ERR);

        do {
            switch (choice) {
                case 1:
                    println("USER - Piedra");
                    break;
                case 2:
                    println("USER - Papel");
                    break;
                case 3:
                    println("USER - Papelera");
                    break;
                default:
                    println("ERROR: Entrada incorrecta");
                    println("Prueba otra vez");
                    choice = UtilesEntrada.leerEntero(MSG_ELIGE, MSG_ERR);
                    break;
            }
        } while (!(choice == 1 || choice == 2 || choice == 3));
        return choice;
    }

    public static double generaApuesta() {
        double apuesta;

        println();
        apuesta = UtilesEntrada.leerReal(MSG_APUESTA, MSG_ERR);

        while (apuesta > euros) {
            println("ERROR: Saldo insuficiente");
            println("Prueba de nuevo..........");
            println();
            apuesta = UtilesEntrada.leerReal(MSG_APUESTA, MSG_ERR);
        }
        return apuesta;
    }

    public static int juegaMaquina() {
        Random RND = new Random();
        int com = 1 + RND.nextInt(3);

        switch (com) {
            case 1:
                println("CPU - Piedra");
                break;
            case 2:
                println("CPU - Papel");
                break;
            case 3:
                println("CPU - Papelera");
                break;
            default:
                break;
        }
        return com;
    }

    public static void muestraBanner() {
        println("**************************************************");
        println("    Bienvenido a PIEDRA / PAPEL / PAPELERA ");
        println("**************************************************");
        println();
        println("Pulsa Enter para empezar");
        SCN.nextLine();

        println("¿Sabes cómo jugar a Piedra, Papel o Papelera? "
                + "[1 = sí; 2 = no]");
        int ent = SCN.nextInt();

        while (!(ent == 1 || ent == 2)) {
            println(MSG_ERROP);
            println("Prueba otra vez");
            ent = SCN.nextInt();
        }
        if (ent == 2) {
            println("Es fácil:");
            println("1.- Piedra gana a papelera.");
            println("2.- Papel gana a piedra.");
            println("3.- Papelera gana a papel.");
            println();
            println("Si ha quedado claro vamos con el juego");
            duerme();
            println("En 3....");
            duerme();
            println(".....2..");
            duerme();
            println(".......1");
            duerme();
            println(PACO);
        }
    }

    public static void muestraBannerSal() {
        println("**************************************");
        println("El resultado final es...");
        println();
    }

//   ********************************* VA *****************************
    public static void duerme() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
//   **************************************    VARIOS PRINT

    public static void println() {
        System.out.println();
    }

    public static void println(String nombre) {
        System.out.println("" + nombre);
    }

    public static void printf(String nombre, double valor) {
        System.out.printf(nombre, valor);
    }
}
