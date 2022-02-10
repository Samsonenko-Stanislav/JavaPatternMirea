package ru.mirea.Task1;


public class Main {
    public static void main(String args[]){
      Integer[] a = {1, 2, 3,4, 5, 6, 7, 8,9, 0};
      Integer[] b = {1,2,3,4,5};
      CompArray<Integer> c = new CompArray<Integer>();
      System.out.println(c.compare(a,b));
    }
}
