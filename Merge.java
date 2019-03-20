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
    while(index <= hi){
      int count = index;
      while(count > lo && data[index] < data[count - 1]){
        count --;
      }
      shift(data, index, count);
      index++;
    }
  }
  public static void shift(int[] data, int oldNum, int newNum){
    int temp = oldNum;
    for(int i = oldNum; i > newNum; i--){
      data[i] = data[i - 1];
    }
    data[newNum] = temp;
  }
  public static void mergesort(int[] data){
    int [] newdata = new int[data.length];
    sortHelper(data, 0, data.length -1, newdata);
  }
  public static void sortHelper(int[] data, int low, int high, int[] newdata){
    if(high - low <= 20){
      insertionsort(data, low, high);
    }
    for(int i = low; i < high; i++){
      newdata[i] = data[i];
    }
    int middle = (low + high) / 2;
    sortHelper(newdata, low, middle, data);
    sortHelper(newdata, middle + 1, high, data);
    merge(data, low, middle, high, newdata);
  }
  public static void main(String[]args){
    }

}
