/* 
 * Copyright 2019 mon-mode - 0mon.mode@gmail.com
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
package org.japo.java.main;

import org.japo.java.app.App;

/**
 *
 * @author mon-mode
 */
public final class Main {

    //clave de acceso: Declaramos la constante del serial como private para que 
    //no pueda ser accesible desde fuera.
    private static final String ACCESS_UID = "mon_mode21442565426";

    //Punto de entrada al programa
    public static final void main(String[] args) {

        if (args.length == 1 && args[0].equals(ACCESS_UID)) {
            // Crear aplicación
            final App APP = new App();
            //Lanzar aplicación
            APP.launchApp();
        } else {
            System.out.println("Acceso Denegado");
            System.out.println("---");
            System.out.println("Contacte con su servicio técnico");
        }
    }
}
