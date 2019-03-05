import java.util.Scanner;
import java.util.Random;

class SlectionSort{
  static void swap(int[] a, int dx1, int dx2){
    int t = a[dx2];
    a[dx2] = a[dx1];
    a[dx1] = t;
  }

  static void selectionsort(int[] a,int n){
    int min = 0;
    for(int i=0; i<n-1; i++){
      min = i;
      for(int j=i+1; j<n; j++){
        if(a[min]>a[j]){
          min = j;
        }
        swap(a,min,i);
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
    selectionsort(a,nx);
    long end = System.currentTimeMillis();
    System.out.println((end - start)  + "ms");
    for(int j=0; j<nx; j++){
        System.out.println("x[" + j + "] = " + a[j]);
    }

  }
}
