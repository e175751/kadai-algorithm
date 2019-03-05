import java.util.Scanner;
import java.util.Random;

class BubbleSort{
  static void swap(int[] a, int idx1, int idx2){
      int t = a[idx1];
      a[idx1] = a[idx2];
      a[idx2] = a[idx1];
  }

  static void bubblesprt(int[] a, int n){
    for(int i=0; i<n-1; j++)
      for(int j=n-1; j>i; j--)
       if(a[j-1]>a[j])
        swap(a,j-1,j);
  }

  static void main(String[] args){
    System.out.println("回数入力");
    Scanner scan = new Scanner(System.in);
    int nx = scan.nextInt();
    int a[] = new int[nx];
    for(int i=0; i<scan; i++){
      Random rand = new Random();
      a[i] = rand;
    }
    bubblesprt(a,nx);
    for(int j=0; j<nx; j++){
        System.out.println("x[" + j + "] = " + a[j]);
    }


}
