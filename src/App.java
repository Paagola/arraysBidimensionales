public class App {

    public static final String BG_WHITE = "\u001B[47m"; // Blanco para fondo
    public static final String RESET = "\u001B[0m"; // Resetear color

    public static void main(String[] args) throws Exception {
        menu();
        int eleccion = Integer.parseInt(System.console().readLine(" -> "));

        switch (eleccion) {

            // EJERCICIO 1
            case 1:
                int[][] array1 = new int[3][6];

                // llenar el array bidimensional del números random entre 0 y 100
                for (int i = 0; i < array1.length; i++) {
                    for (int j = 0; j < array1[i].length; j++) {
                        array1[i][j] = (int) (Math.random() * 101);
                    }
                }

                // imprimir array bidimensional con sus titulos en fila y columnas
                for (int i = 0; i < array1.length + 1; i++) {
                    for (int j = 0; j < array1[0].length + 1; j++) {
                        if (i == 0) {
                            System.out.print((j == 0) ? "        " : " Columna " + j);
                        } else {
                            System.out.print((j == 0) ? "Fila " + (i - 1) : "        " + array1[i - 1][j - 1]);
                        }
                    }
                    System.out.println();
                }
                break;

            case 2: // EJERCICIO 2
                int[][] array2 = new int[4][5];
                int sumaFil = 0;
                int sumaCOl = 0;
                int contador = 0;

                for (int i = 0; i < array2.length; i++) {

                    if (i != array2.length - 1) {
                        for (int j = 0; j < array2[0].length; j++) {
                            if (j != array2[0].length - 1) {
                                array2[i][j] = Integer
                                        .parseInt(System.console().readLine("Fila " + i + ", columna " + j + " -> "));
                                sumaFil += array2[i][j];
                            } else {
                                array2[i][j] = sumaFil;
                                sumaFil = 0;
                            }
                        }
                    }
                }

                // Suma de todas las columnas en la última fila
                while (contador <= array2.length) {

                    for (int i = 0; i < array2.length; i++) {
                        sumaCOl += array2[i][contador];
                    }
                    array2[array2.length - 1][contador] = sumaCOl;
                    sumaCOl = 0;
                    contador++;
                }

                imprimirArrayBidi(array2);

                break;

            // EJERCICIO 3
            case 3:
                int[][] array3 = new int[4][5];
                sumaFil = 0;
                sumaCOl = 0;
                contador = 0;

                for (int i = 0; i < array3.length; i++) {

                    if (i != array3.length - 1) {
                        for (int j = 0; j < array3[0].length; j++) {
                            if (j != array3[0].length - 1) {
                                array3[i][j] = (int) (Math.random() * 1001);
                                sumaFil += array3[i][j];
                            } else {
                                array3[i][j] = sumaFil;
                                sumaFil = 0;
                            }
                        }
                    }
                }

                // Suma de todas las columnas en la última fila
                while (contador <= array3.length) {

                    for (int i = 0; i < array3.length; i++) {
                        sumaCOl += array3[i][contador];
                    }
                    array3[array3.length - 1][contador] = sumaCOl;
                    sumaCOl = 0;
                    contador++;
                }

                for (int i = 0; i < array3.length; i++) {
                    for (int j = 0; j < array3[0].length; j++) {
                        System.out.print(array3[i][j] + "   |   ");
                        Thread.sleep(200);
                    }
                    System.out.println();
                }

                break;

            // EJERCICIO 4
            case 4:
                int[][] array4 = crearArrayBidi(6, 10, 1000);

                int maximo = array4[0][0];
                int minimo = array4[0][0];

                for (int i = 0; i < array4[0].length + 1; i++) {
                    if (i == 0)
                        System.out.print("   ");
                    else {
                        System.out.print("   " + (i - 1) + " ");
                    }

                }
                System.out.println("\n  ----------------------------------------------------");

                for (int i = 0; i < array4.length; i++) {
                    for (int j = 0; j < array4[i].length; j++) {

                        if (array4[i][j] > maximo)
                            maximo = array4[i][j];

                        if (array4[i][j] < minimo)
                            minimo = array4[i][j];

                        if (j == 0)
                            System.out.print(i + " | " + ((array4[i][j] < 100) ? " " : "") + array4[i][j]);
                        else if (j == array4[i].length - 1)
                            System.out.print("  " + array4[i][j] + "  |");
                        else
                            System.out.print("  " + ((array4[i][j] < 100) ? " " : "") + array4[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("  ----------------------------------------------------");

                System.out.println("Numero mayor = " + maximo);
                System.out.println("Numero minimo = " + minimo);
                break;

            // EJERCICIO 5
            case 5:

                int[][] array5 = new int[6][10];

                int num = 0;

                for (int i = 0; i < array5.length; i++) {
                    for (int j = 0; j < array5[0].length; j++) {
                        do {
                            num = (int) (Math.random() * 1001);
                        } while (numeroEnArray(array5, num));
                        array5[i][j] = num;
                    }
                }

                maximo = array5[0][0];
                minimo = array5[0][0];

                for (int i = 0; i < array5[0].length + 1; i++) {
                    if (i == 0)
                        System.out.print("   ");
                    else {
                        System.out.print("   " + (i - 1) + " ");
                    }

                }
                System.out.println("\n  ----------------------------------------------------");

                for (int i = 0; i < array5.length; i++) {
                    for (int j = 0; j < array5[i].length; j++) {

                        if (array5[i][j] > maximo)
                            maximo = array5[i][j];

                        if (array5[i][j] < minimo)
                            minimo = array5[i][j];

                        if (j == 0)
                            System.out.print(i + " | " + ((array5[i][j] < 100) ? " " : "") + array5[i][j]);
                        else if (j == array5[i].length - 1)
                            System.out.print("  " + array5[i][j] + "  |");
                        else
                            System.out.print("  " + ((array5[i][j] < 100) ? " " : "") + array5[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("  ----------------------------------------------------");

                System.out.println("Numero mayor = " + maximo);
                System.out.println("Numero minimo = " + minimo);
                break;

            // EJERCICIO 6
            case 6:

                String[][] buscaMinas = new String[4][5];

                for (int i = 0; i < buscaMinas.length; i++) {
                    for (int j = 0; j < buscaMinas[i].length; j++) {
                        buscaMinas[i][j] = "  ";
                    }
                }

                boolean salir = false;

                int xPos = -1;
                int yPos = -1;

                int xMina = (int) (Math.random() * buscaMinas.length);
                int yMina = (int) (Math.random() * buscaMinas[0].length);

                int xTesoro = 0;
                int yTesoro = 0;

                do {
                    xTesoro = (int) (Math.random() * buscaMinas.length);
                    yTesoro = (int) (Math.random() * buscaMinas[0].length);
                } while (xMina == xTesoro && yMina == yTesoro);

                do {
                    if ((xPos == xMina && yPos == yMina) || (xPos == xTesoro && yPos == yTesoro)) {

                        System.out.println((xPos == xMina && yPos == yMina) ? "HAS PISADO UNA MINA!!!"
                                : "HAS ENCONTRADO EL TESORO!!!");

                        for (int i = 0; i < buscaMinas.length + 1; i++) {
                            for (int j = 0; j < buscaMinas[0].length + 1; j++) {
                                if (i == buscaMinas.length) {
                                    System.out.print("""
                                              ----------
                                              0 1 2 3 4
                                            """);
                                    j = buscaMinas[0].length;
                                }

                                else if (j == 0 && j != buscaMinas[i].length)
                                    System.out.print(3 - i + "|");

                                if (i < buscaMinas.length && j < buscaMinas[0].length) {
                                    if (j == xMina && i == yMina) {
                                        System.out.print(" *");
                                    } else if (j == xTesoro && i == yTesoro) {
                                        System.out.print(" $");
                                    } else {
                                        System.out.print(buscaMinas[i][j]);
                                    }
                                }

                            }
                            System.out.println();
                        }

                        salir = true;

                    } else {
                        System.out.println("¡BUSCA EL TESORO!");
                        for (int i = 0; i < buscaMinas.length + 1; i++) {
                            for (int j = 0; j < buscaMinas[0].length + 1; j++) {
                                if (i == buscaMinas.length) {
                                    System.out.print("""
                                              ----------
                                              0 1 2 3 4
                                            """);
                                    j = buscaMinas[0].length;
                                }

                                else if (j == 0 && j != buscaMinas[i].length)
                                    System.out.print(3 - i + "|");

                                if (i < buscaMinas.length && j < buscaMinas[0].length) {
                                    if (yPos == i && xPos == j) {
                                        buscaMinas[i][j] = " X";
                                    }

                                    System.out.print(buscaMinas[i][j]);
                                }

                            }
                            System.out.println();
                        }

                        if (!salir) {
                            xPos = Integer.parseInt(System.console().readLine("Coordenada x: "));
                            yPos = Integer.parseInt(System.console().readLine("Coordenada y: "));
                        }
                    }

                } while (!salir);
                break;

            case 7:

                contador = 0;
                String[][] tablero = new String[10][10];

                Character numeracion = '8';
                Character letras = 'a';

                int alfilX = tablero[0].length/2;
                int alfilY = tablero.length/2; 

                salir = true;

                String BLANCO = BG_WHITE + "  " + RESET;
                String NEGRO = "  ";

                String posicion = "";

                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero[0].length; j++) {
                        if (i == 0 || i == tablero.length - 1) {

                            if (j == 0 || j == tablero[0].length - 1)
                                tablero[i][j] = " ";
                            else {
                                tablero[i][j] = letras + " ";
                                letras++;
                            }

                            if (j == tablero[0].length - 1) {
                                letras = 'a';
                            }

                        }

                        else if (j == 0 || j == tablero[0].length - 1) {
                            tablero[i][j] = numeracion + "";
                            if (j == tablero[0].length - 1)
                                numeracion--;
                        }

                        else {
                            tablero[i][j] = (contador % 2 == 0) ? BLANCO : NEGRO;
                            contador++;
                            if (contador > 7 && i % 2 != 0)
                                contador = 1;
                            else if (contador > 8 && i % 2 == 0)
                                contador = 0;
                        }
                    }
                }

                System.out.println("Imprimiendo tablero");
                imprimirArrayBidiStr(tablero);

                

                do{

                    posicion = System.console().readLine("Introduzca la posición del alfil: ");

                    alfilX = (int)posicion.charAt(0)-96;
                    alfilY = 9 - ((int)posicion.charAt(1)-48);
                    

                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[0].length; j++) {
                            if ((Math.abs(alfilX - j) == Math.abs(alfilY-i))&&(!(alfilX == j && alfilY == i)) 
                            && ((i != 0 && i != tablero.length-1) && (j != 0 && j != tablero[0].length-1))){
                                if (tablero[i][j] == BLANCO){
                                    tablero[i][j] = BG_WHITE + "º " + RESET;
                                } else{
                                    tablero[i][j] = "º ";
                                }
                            }
                            else if (alfilX == j && alfilY == i){
                                if (tablero[i][j] == BLANCO){
                                    tablero[i][j] = BG_WHITE + "/ " + RESET;
                                } else {
                                    tablero[i][j] = "/ ";
                                }
                            }
                        }
                    }

                    imprimirArrayBidiStr(tablero);

                numeracion = '8';
                letras = 'a';

                    for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero[0].length; j++) {
                        if (i == 0 || i == tablero.length - 1) {

                            if (j == 0 || j == tablero[0].length - 1)
                                tablero[i][j] = " ";
                            else {
                                tablero[i][j] = letras + " ";
                                letras++;
                            }

                            if (j == tablero[0].length - 1) {
                                letras = 'a';
                            }

                        }

                        else if (j == 0 || j == tablero[0].length - 1) {
                            tablero[i][j] = numeracion + "";
                            if (j == tablero[0].length - 1)
                                numeracion--;
                        }

                        else {
                            tablero[i][j] = (contador % 2 == 0) ? BLANCO : NEGRO;
                            contador++;
                            if (contador > 7 && i % 2 != 0)
                                contador = 1;
                            else if (contador > 8 && i % 2 == 0)
                                contador = 0;
                        }
                    }
                }
                    

                }while(salir);

                break;

            default:
                System.out.println("Número no válido!!!");

                break;
        }
    }

    public static void menu() {
        System.out.println("""
                  EJERCICIOS ARRAYS BIDIMENSIONALES
                ====================================
                1 EJERCICIO 1 | 6 BUSCA MINAS   |
                2 EJERCICIO 2 | 7 ALFIL AJEDREZ |
                3 EJERCICIO 3 |
                4 EJERCICIO 4 |
                5 EJERCICIO 5 |
                """);
    }

    public static void imprimirArrayBidi(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "   |   ");
            }
            System.out.println();
        }
    }

    public static void imprimirArrayBidiStr(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] crearArrayBidi(int filas, int columnas, int hasta) {
        int[][] newArray = new int[filas][columnas];

        // llenar el array bidimensional del números random entre 0 y 100
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                newArray[i][j] = (int) (Math.random() * hasta + 1);
            }
        }
        return newArray;
    }

    public static boolean numeroEnArray(int[][] bidi, int num) {
        for (int i = 0; i < bidi.length; i++) {
            for (int j = 0; j < bidi[0].length; j++) {
                if (num == bidi[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
