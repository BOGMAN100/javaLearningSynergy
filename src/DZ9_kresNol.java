import java.util.Scanner;

public class DZ9_kresNol {
    public static int turn;
    public static boolean haveWinner;

    public static void main(String[] args) {
        turn = 1;
        String[][] area = {{"[ ]", "[ ]", "[ ]" }, {"[ ]", "[ ]", "[ ]" }, {"[ ]", "[ ]", "[ ]" }};
        while (!haveWinner){
            printArea(area);
            setChar(area);
            checkWin(area);
        }
    }

    public static void printArea(String[][] area) {
        int i = 1;
        System.out.println("   1   2   3");
        for (String[] row : area) {
            if (row != null) {
                System.out.print(i++ + " ");
                for (String col : row) {
                    System.out.print(col + " ");
                }
            }
            System.out.println();
        }
    }

    public static void setChar(String[][] area) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Сейчас ходит: ");
        if (turn % 2 == 0)
            System.out.print("X");
        else if (turn % 2 == 1) {
            System.out.print("0");
        }
        System.out.println("\n" + "Это " + turn + "й ход");
        System.out.print("Choose row: ");
        int row = scan.nextInt() - 1;
        System.out.print("Choose col: ");
        int col = scan.nextInt() - 1;
//        scan.close();
        if (col < 3 && row < 3) {
            if (area[row][col].equals("[ ]")) {
                if (turn % 2 == 0)
                    area[row][col] = "[X]";
                else if (turn % 2 == 1) {
                    area[row][col] = "[0]";
                }
                turn++;
            } else {
                System.out.println("Эту ячейку выбрать нельзя");
            }

        } else {
            System.out.print("Эту ячейку выбрать нельзя");
        }
    }

    public static void checkWin(String[][] area) {
        String[] elements = new String[9];
        int i = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                elements[i] = area[r][c];
                i++;
            }
        }
        String X = "[X]", O = "[0]";
        if(
                elements[0].equals(elements[1]) && elements[1].equals(elements[2]) && elements[2].equals(X) ||
                        elements[3].equals(elements[4]) && elements[4].equals(elements[5]) && elements[5].equals(X) ||     // линии Х
                        elements[6].equals(elements[7]) && elements[7].equals(elements[8]) && elements[8].equals(X) ||
                        elements[0].equals(elements[3]) && elements[3].equals(elements[6]) && elements[6].equals(X) ||
                        elements[1].equals(elements[4]) && elements[4].equals(elements[7]) && elements[7].equals(X) ||     // колонны Х
                        elements[2].equals(elements[5]) && elements[5].equals(elements[8]) && elements[8].equals(X) ||
                        elements[0].equals(elements[4]) && elements[4].equals(elements[8]) && elements[8].equals(X) ||
                        elements[2].equals(elements[4]) && elements[4].equals(elements[6]) && elements[6].equals(X)    // две диагонали
        ) {
            haveWinner = true;
            printArea(area);
            System.out.println("Победили крестики!");
        }
        else if (
                elements[0].equals(elements[1]) && elements[1].equals(elements[2]) && elements[2].equals(O) ||
                        elements[3].equals(elements[4]) && elements[4].equals(elements[5]) && elements[5].equals(O) ||     // линии 0
                        elements[6].equals(elements[7]) && elements[7].equals(elements[8]) && elements[8].equals(O) ||
                        elements[0].equals(elements[3]) && elements[3].equals(elements[6]) && elements[6].equals(O) ||
                        elements[1].equals(elements[4]) && elements[4].equals(elements[7]) && elements[7].equals(O) ||     // колонны 0
                        elements[2].equals(elements[5]) && elements[5].equals(elements[8]) && elements[8].equals(O) ||
                        elements[0].equals(elements[4]) && elements[4].equals(elements[8]) && elements[8].equals(O) ||
                        elements[2].equals(elements[4]) && elements[4].equals(elements[6]) && elements[6].equals(O)    // две диагонали
        ) {
            haveWinner = true;
            printArea(area);
            System.out.println("Победили нолики!");
        }
    }
}