import java.util.Scanner;
import java.util.Random;

class MergeSort{
  public static void sort(int[] array, int low, int high){
        if(low < high){
            int middle = (low + high) / 2;
            sort(array, low , middle);
            sort(array, middle+1, high);
            merge(array, low, middle, high);
        }

    }
    public static void merge(int[] array, int low, int middle, int high){
        int[] helper = new int[array.length];

        for (int i = low; i <= high; i++){
            helper[i] = array[i];
        }
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high){
            if (helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft ++;
            }
            else {
                array[current] = helper[helperRight];
                helperRight ++;

            }
            current ++;
        }
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++){
            array[current + i] = helper[helperLeft + i];
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
    sort(a,0,nx-1);
    long end = System.currentTimeMillis();
    System.out.println((end - start)  + "ms");
  

  }
}
