import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    data =(E[])new  Object[10];
    size = 0;
    start = 0;
    end = 0;
    }
  public MyDeque(int initialCapacity){
    data = (E[])new  Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
   }
  public int size(){
    return size;
    }
  public String toString(){
    if (size == 0) {
      return "{}";
    }
    String output = "[";
    if (start < end) {
      for (int i = start; i < end; i+= 1) {
        output += data[i];
        if (i < end - 1 ) {
          output += ", ";
        }
      }
    }
    if (start > end) {
      for(int i = start; i < data.length; i++) {
        output += data[i];
        if (i < data.length - 1 && i != 1) {
          output += ", ";
        }
      }
      for(int i = 0; i < end; i++) {
        output += data[i];
        if (i < end - 1) {
          output += ", ";
        }
      }
    }
    output += "]";
    return output;
    }
  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if(size == data.length - 1) {
      E[] temp = (E[]) new Object[data.length * 2 + 1];
      temp[0] = element;
      if (start <= end) {
        for(int i = 0; i < end; i+= 1) {
          temp[i + 1] = data[start + i];
        }
      }
      else {
        int i = 0;
        for(i = 0;i + start <= data.length - 1; i+= 1) {
          temp[i + 1] = data[start + i];
        }
        for(int j = 0; j < end; j+= 1) {
          temp[i + j + 1] = data[j];
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
   if (element == null) {
     throw new NullPointerException();
   }
    if (size == data.length - 1) {
      E[] temp = (E[]) new Object[data.length * 2 + 1];
      if (start >= end) {
        int i = 0;
        for(i = 0; i + start < data.length - 1; i+= 1){
          temp[i] = data[i + start];
        }
        for(int j = 0; j < end; j++) {
          temp[i + j + 1] = data[j];
        }
      }
      start = 0;
      end = data.length;
      data = temp;
      data[end] = element;
    }
    else if (end == data.length - 1) {

      data[end] = element;
      end = 0;
    }
    else {
      data[end] = element;
      end += 1;
    }
    size += 1;
  }
  public E removeFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    int temp = start;
    start += 1;
    if(start == data.length) {
      start = 0;
    }
    size -= 1;
    return data[temp];
    }
  public E removeLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    int temp = end;
    end -= 1;
    if (end == -1) {
      end = data.length;
    }
    size -= 1;
    return data[temp];
  }
  public E getFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[start];
  }
  public E getLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[end];
  }


  public static void main(String[] args) {
    MyDeque<Integer> deque = new MyDeque<>();
    deque.addLast(5);
    deque.addFirst(6);
    for (int i = 0; i< 20;i+= 1) {
      deque.addFirst(i);
    }
    for (int i = 0; i< 22;i+= 1) {
      deque.removeFirst();
    }
    System.out.println(deque);
  }
}
