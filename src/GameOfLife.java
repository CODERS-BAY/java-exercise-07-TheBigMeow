public class GameOfLife {
    public static void main(String[] args) {
        boolean[][] field = new boolean[12][12];

        field[2][1] = true;
        field[2][3] = true;
        field[3][2] = true;
        field[3][3] = true;
        field[4][2] = true;


        printField(field);


        for (int i = 1; i <= 10; i++) {
            System.out.println("Generation:" + i);
            field = createNewField(field);
            printField(field);
        }


    }

    private static boolean[][] createNewField(boolean[][] field) {
        boolean[][] gen = new boolean[12][12];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                int counterNachbar = 0;
                if (i > 0 && j > 0) {
                    if (field[i - 1][j - 1]) {
                        counterNachbar++;
                    }
                }
                if (i > 0) {
                    if (field[i - 1][j]) {
                        counterNachbar++;
                    }
                }
                if (i > 0 && j < field.length - 1) {
                    if (field[i - 1][j + 1]) {
                        counterNachbar++;
                    }
                }
                if (j < field.length - 1) {
                    if (field[i][j + 1]) {
                        counterNachbar++;
                    }
                }
                if (i < field.length - 1 && j < field.length - 1) {
                    if (field[i + 1][j + 1]) {
                        counterNachbar++;
                    }
                }
                if (i < field.length - 1) {
                    if (field[i + 1][j]) {
                        counterNachbar++;
                    }
                }
                if (i < field.length - 1 && j > 0) {
                    if (field[i + 1][j - 1]) {
                        counterNachbar++;
                    }
                }
                if (j > 0) {
                    if (field[i][j - 1]) {
                        counterNachbar++;
                    }
                }
                if (counterNachbar < 2) {
                    gen[i][j] = false;
                }
                if ((counterNachbar == 2 || counterNachbar == 3) && field[i][j]) {
                    gen[i][j] = true;
                }
                if (counterNachbar > 3) {
                    gen[i][j] = false;
                }
                if (counterNachbar == 3 && !field[i][j]) {
                    gen[i][j] = true;
                }
            }
        }
        return gen;
    }

    private static void printField(boolean[][] field) {

        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j]) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

}
