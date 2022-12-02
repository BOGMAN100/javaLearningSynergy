import java.util.Arrays;
public class DZ8 {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) Math.round(Math.random()*100) + 1;
//            System.out.println(array[i]);
        }
//        bubbleSort(array);
        quickSort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    private static void bubbleSort(int[] array) {
        boolean needSwap = true;
        while (needSwap) {
            needSwap = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i-1]){
                swap(array, i, i-1);
                needSwap = true;
                }
            }
        }
    }
    private static void swap(int[] array, int firstIndex, int secondIndex) {   // меняет значение элементов ({5,10} станет {10,5})
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
    private static int partition(int[] array, int left, int right) {
        int pivot = array[(right + left) / 2];  // чисто относителько которого буде разбиваться массив
        while (left <= right) {
            while (array[left] < pivot) {      // пока числа слева меньше основного, переносим левый индекс правее
                left++;
            }
            while (array[right] > pivot) {    // также в обратном порядке слева
                right--;
            }
            if (left <= right) {              // заменяем  и делаем шаг индексам
                swap(array, left, right);
                left++;
                right--;
            }                                 // делаем так пока 2 части полностью не поделим массив на 2 части
        }
        return left; // возвращаем центральный индекс
    }
    public static void quickSort(int[] array, int left, int right) {
        int index = 0;
        if (array.length > 1) {
            index = partition(array, left, right);       // центр + деление
            if (left < index - 1) {    // сортируем левую часть и продолдаем рекурсией
                quickSort(array, left, index - 1);
            }
            if (index < right) {       // также с правой частью
                quickSort(array, index, right);
            }
        }
    }
}
