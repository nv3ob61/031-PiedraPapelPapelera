/* 
 * Copyright 2019 
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
package org.japo.java.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author ho
 */
public class UtilesEntrada {


    // Scanner + Codificación Windows
    public static final Scanner SCN = new Scanner(System.in, "ISO-8859-1");

    // Locale Spanish
    public static final Locale LCL = new Locale("es", "ES");

    // Consola >> Entero
    public static final int leerEntero(String msgUsr, String msgErr) {
        // Dato a introducir
        int dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextInt();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }


    // Consola >> Real
    public static final double leerReal(String msgUsr, String msgErr) {
        // Dato a introducir
        double dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextDouble();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }
}