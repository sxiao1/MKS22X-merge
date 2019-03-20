import java.util.Arrays;

public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void merge(int[]data, int low, int middle, int high, int temp[]){
    int num1 = low;
    int num2 = middle +1;
    for(int i = num1; i <= high; i++){
      if(num1 <= high && num2 <= middle && temp[num2] <= temp[num1]){
        data[i] = temp[num2]; //if the number is less than the high and middle and it is less than low, then it will take the position of the middle and increases
        num2++;
      }
      else if(num1 <= high && num2 <= middle && temp[num1] <= temp[num2]){
        data[i] = num1; //the same as above but if the number is less than the middle the it will add to the beginning
        num1++;
      }
      else if(num1 > middle){
        data[i] = temp[num2];
        num2++;
      }
      else{
        if(num2 > high){
          data[i] = temp[num1];
          num1++;
        }
      }
    }
  }
  public static void mergesort(int[] data){
    int [] newdata = new int[data.length]; //create a new array
    sortHelper(data, 0, data.length -1, newdata);
  }
  public static void sortHelper(int[] data, int low, int high, int[] newdata){
    if(high - low <= 20){
      insertionsort(data, low, high);
      return;
    }
    for(int i = low; i < high; i++){
      newdata[i] = data[i];
    }
    int middle = (low + high) / 2; //pick a numer in the middle
    sortHelper(newdata, low, middle, data); //recurse through both halves of the array
    sortHelper(newdata, middle + 1, high, data);
    merge(data, low, middle, high, newdata);
  }
  public static void main(String[]args){
    }
  public static void insertionsort(int data[], int lo, int hi){
    int index = lo + 1; //starting from one more than the low
    while(index <= hi){
      int count = index;
      while(count > lo && data[index] < data[count - 1]){
        count --; //if the count is grater than the low and the index is less than the count value, then the count value decreases
      }
      shift(data, index, count); //calling the function to move over the spaces in the array
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

}
