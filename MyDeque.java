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
    if(start != 0 && size == data.length - 1) {
      start = start - 1;
      data[start] = element;
    }
    if(start == 0 && size == data.length - 1) {
      start = data.length - 1;
      data[start - 1] = element;
    }
    if(size == data.length - 1) {
      E[] temp = (E[]) new Object[data.length * 2];
      temp[0] =  element;
      for(int i = 0; i + start <= end; i++) {
        temp[i + 1] = data[i + start];
      }
      start = 0;
      end = data.length;
    }
    size += 1;
    }
  public void addLast(E element){
    if(end != data.length - 1)


  }





  }
  public E removeFirst(){ }
  public E removeLast(){ }
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
}
