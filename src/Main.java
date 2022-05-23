import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = new int[100000];


                /**№1*/
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100000 + 1000);
        }


                /**№2*/
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 1 && arr[i] <= 2) count++;
        }
        System.out.println("Кількість чисел у діапазоні [1;2]: " + count);


                /**№3*/
        int ind = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1001) {
                ind = i;
                break;
            }
        }
        System.out.println("Найменший індекс елементу масиву, що дорівнює 1001: " + ind);


                /**№4*/
//        for (int i = 0; i < 10; i ++) {
//            System.out.print(arr[i] + " ");
//        }
        //System.out.println();
        long start = System.currentTimeMillis();
        arr = sort(arr);
        long finish = System.currentTimeMillis();
//        for (int i = 0; i < 10; i ++) {
//            System.out.print(arr[i] + " ");
//        }
        System.out.println("Час роботи алгоритму сортування масиву з 100 000 елементів: " + (finish - start));


            /**№5*/
        int[] arr2 = new int[200000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rnd.nextInt(100000 + 1000);
        }
//        for (int i = 0; i < 10; i++) {
//            System.out.print(arr2[i] + " ");
//        }
        //System.out.println();
        long start2 = System.currentTimeMillis();
        arr2 = sort(arr2);
        long finish2 = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//            System.out.print(arr2[i] + " ");
//        }
        //System.out.println("\nЧас роботи алгоритму сортування: " + (finish - start));
        System.out.printf("Різниця роботи алгоритму сортування для масиву " +
                "з 200 000 та 100 000 = (%d - %d) = %d",
                finish2-start2,finish-start,(finish2-start2) - (finish-start));


                /**№6*/
    }

    public static int findBinary(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        while (true) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == 1001) {
                return mid;
            }
            if (lo>hi) {
                return -1;
            }
            if (arr[mid] < 1001) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
    }

    public static int[] sort(int[] arr) {

        int temp;
        int item;
        for (int i = 1; i < arr.length; i++) {

            temp = arr[i];
            item = i - 1;
            while (item >= 0 && arr[item] > temp) {
                arr[item + 1] = arr[item];
                arr[item] = temp;
                item--;
            }
        }
        return arr;
    }
}


