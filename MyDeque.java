public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    E[] data =(E[])new  Object[10];
    size = 0;
    start = 0;
    end = 0;
    }
  public MyDeque(int initialCapacity){
    E[] data = (E[])new  Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
   }
  public int size(){
    return size;
    }
  public String toString(){
    String output = "{";
    if (start < end) {
      for (int i = start; i < end; i+= 1) {
        output += data[i];
      }
    }
    if (start > end) {
      for(int i = start; i < data.length; i++) {
        output += data[i] + "";
      }
      for(int i = 0; i <= end; i++) {
        output += data[i] + "";
      }
    }
    output += "}";
    return output;
    }
  public void addFirst(E element){
    if(size == data.length - 1) {
      E[] temp = (E[]) new Object[data.length * 2 + 1];
      temp[0] = element;
      if (start <= end) {
        for(int i = 0; i <= end; i+= 1) {
          temp[i + 1] = data[start + i];
        }
      }
      else {
        int i = 0;
        for(i = 0;i + start <= data.length - 1; i+= 1) {
          temp[i + 1] = data[start + i];
        }
        for(int j = 0; j <= end; j+= 1) {
          temp[i + j + 2] = data[j];
        }
      }
      start = 0;
      end = data.length;
      data = temp;
    }
    else if(start == 0) {
      start = data.length - 1;
      data[start] = element;
    }
    else {
      start -= 1;
      data[start] = element;
    }
    size += 1;
  }
 public void addLast(E element){
    if (size == data.length - 1) {
      E[] temp = (E[]) new Object[data.length * 2 + 1];
      if (start >= end) {
        int i = 0;
        for(i = 0; i + start < data.length - 1; i+= 1){
          temp[i] = data[i + start];
        }
        for(int j = 0; j <= end; j++) {
          temp[i + j + 1] = data[j];
        }
      }
      start = 0;
      end = data.length;
      data = temp;
      data[end] = element;
    }
    else if (end == data.length - 1) {
      end = 0;
      data[end] = element;
    }
    else {
      end += 1;
      data[end] = element;
    }
    size += 1;
  }
  public E removeFirst(){
    if (size == 0) {
      return null;
    }
    int temp = start;
    start += 1;
    if(start == data.length) {
      start == 0;
    }
    return data[temp];
    }
  public E removeLast(){
    if (size == 0) {
      return null;
    }
    int temp = end;
    end -= 1;
    if (end == -1) {
      end = data.length - 1;
    }
    return data[temp];
  }
  public E getFirst(){
    if (size == 0) {
      return null;
    }
    return data[start];
  }
  public E getLast(){
    if (size == 0) {
      return null;
    }
    return data[end];
  }


  public static void main(String[] args) {
    MyDeque midori = new MyDeque();

  }
}
