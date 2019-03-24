import java.util.*;
@SuppressWarnings("unchecked")
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
        if (size() == 0) return "{}";
        String output = "{";
        for (int i = start; i < data.length && (start > end || (start <= end && i <= end)); i++){
          output += data[i];
          if (i != end) output += " ";
          else output += "}";
        }
        if (start > end){
          for (int i = 0; i <= end; i++){
            output += data[i];
            if (i != end) output += " ";
            else output += "}";
          }
        }
        return output;
    }




  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if(size == data.length ) {
      resize();
    }
    if (size != 0) {
      if(start == 0) {
      start = data.length - 1;
    }
    else {
      start -= 1;
    }
  }
    data[start] = element;
    size += 1;
  }
 public void resize() {
    E[] temp = (E[]) new Object[data.length * 2 + 1];
    int index = 0;
    for (int i = start; i < data.length && (start > end || (start <= end && i <= end)); i++) {
      temp[index] = data[i];
      index += 1;
    }
    if (start > end) {
      for (int i = 0; i <= end; i++) {
        temp[index] = data[i];
        index += 1;
      }
    }
    data =temp;
    start =0 ;
    end = size() - 1;
 }
 public void addLast(E element){
   if (element == null) {
     throw new NullPointerException();
   }
    if (size == data.length ) {
      resize();
    }
    if (size() != 0) {
    if (end == data.length - 1) {
      end = 0;
    }
    else {
      end += 1;
    }
  }
    data[end] = element;
    size += 1;
  }
  public E removeFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    if (size == 1) {
      size = 0;
      return data[start];
    }
    E temp = data[start];
    start += 1;
    if(start == data.length) {
      start = 0;
    }
    size -= 1;
    return temp;
    }
  public E removeLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    if (size == 1) {
      size = 0;
      return data[start];
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
      deque.getLast();
      deque.getFirst();
    }
    System.out.println(deque);
  }
}
