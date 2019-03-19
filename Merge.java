import java.util.Arrays;

public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void merge(int[]data, int low, int middle, int high, int temp[]){
    int num1 = low;
    int num2 = middle +1;
    for(int i = num1; i <= high; i++){
      if(num1 <= high && num2 <= middle && temp[num2] <= temp[num1]){
        data[i] = temp[num2];
        num2++;
      }
      else if(num1 <= high && num2 <= middle && temp[num1] <= temp[num2]){
        data[i] = num1;
        num1++;
      }
      else if(num2 > high){
        data[i] = temp[num1];
        num1++;
      }
      else{
        if(num1 > middle){
          data[i] = temp[num2];
          num2++;
        }
      }
    }
  }
  public static void insertionsort(int data[], int lo, int hi){
    int index = lo + 1;
    int counter = 0;
    for(int i = 0; i < data.length; i++){
      counter ++;
    }
    int temp = data[hi];
    if(counter < hi){
      data[counter] = hi;
    }
    for(int x = 0; x < data.length; x++){
      data[hi] = lo;
      data[lo] = temp;
      counter --;
    }
  }
  public static void mergesort(int[] data){
    int [] newdata = new int[data.length];
  }
}
