import java.util.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      MyDeque<Double> numbers = new MyDeque<Double>();
      String holder = "";
      for(int i = 0; i < s.length();i++) {
        if(Character.isDigit(s.charAt(i)) || s.charAt(i) == '.') {
          holder += s.charAt(i);
        }
        if(s.charAt(i) == ' ' && holder != "") {
          numbers.addLast(Double.parseDouble(holder));
          holder = "";
        }
        if(s.charAt(i) == '+' ){
          double store = numbers.removeLast();
          numbers.addLast(numbers.removeLast() + store);
        }
        if(s.charAt(i) == '-' ){
          double store = numbers.removeLast();
          numbers.addLast(numbers.removeLast() -  store);
        }
        if(s.charAt(i) == '*' ){
          double store = numbers.removeLast();
          numbers.addLast(numbers.removeLast() *  store);
        }
        if(s.charAt(i) == '/' ){
          double store = numbers.removeLast();
          numbers.addLast(numbers.removeLast() / store);
        }
      }
      return numbers.getLast();
}
  public static void main(String[] args) {
    System.out.println(eval("10 2.0 +"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("1 2 3 4 5 + * - -"));
  }
}
