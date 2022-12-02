import java.util.Arrays;
import java.util.Scanner;
public class BinarSearch_DZ7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        int[] myArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Arrays.sort(myArray);
        int num = sc.nextInt();
        sc.close();
        int ans = binarySearch( myArray, num,0, myArray.length -1);
        if (ans == -1) {
            System.out.println("Числа "+num+" нет в массиве");
        } else {
            System.out.println("Число " + num + " есть в массиве, под индексом: " +ans);


        }
        */
        String mainString = sc.nextLine();
        String string = sc.nextLine();
        System.out.println(mainString.indexOf(string));
}
    private static int binarySearch(int[] sortedArray, int valueToFind, int low, int high) {  // создаём функцию поиска
        int index = -1;     // если элемент не найден результатом будет -1

        while (low <= high) {                  //между какими элементами производится поиск
            int mid = (low + high) / 2;        // индекс среднего элемента
            if (sortedArray[mid] < valueToFind) {  // будем искать в  меньшей половине
                low = mid + 1;           // +1 из-за того что в условии строго <, а не <=
            } else if (sortedArray[mid] > valueToFind) { //тоже
                high = mid - 1;                          //самое
            } else if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            }
        }
        return index ;
    }
}
