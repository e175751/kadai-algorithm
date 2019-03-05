import java.util.Scanner;
import java.util.Random;

class InsertionSort{

  public static void sort(int[] array, int num){
        for(int i = 1; i < num; i++){
            int j = i;
            while(j >= 1 && array[j-1] > array[j]){
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j-1] = tmp;
                j --;

            }
        }

    }
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    System.out.println("実行回数を入力してください");
    int nx = scan.nextInt();
    int[] a = new int[nx];
    long start = System.currentTimeMillis();
    for(int i=0; i<nx; i++){
      int num = rand.nextInt(10000);
      a[i] = num;
    }
    sort(a, nx);
    long end = System.currentTimeMillis();
    System.out.println((end - start)  + "ms");
   
  }
 }
