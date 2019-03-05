import java.util.Scanner;
import java.util.Random;

class QuickSort{

  static void swap(int[] a, int idx1, int idx2){
    int t = a[idx1];
    a[idx1] = a[idx2];
    a[idx2] = t;
  }

  //ここはクイックソート
  static void quicksort(int a[], int left, int right){
      int pl = left;
      int pr = right;
      int x = a[(pl + pr)/2];
      do{
        while(a[pl]<x) pl++;
        while(a[pr]>x) pr--;
        if(pl <= pr)
          swap(a,pl++,pr--);
      }while(pl <= pr);

      if(left < pr) quicksort(a, left, pr);
      if(pl < right) quicksort(a, pl, right);
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
    quicksort(a, 0, nx-1);
    long end = System.currentTimeMillis();
    System.out.println((end - start)  + "ms");
  }


}
