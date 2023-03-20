import java.util.Arrays;

/**
This program demonstrates the selection sort algorithm by
sorting an array that is filled with random numbers.
*/
public class InsertionSortDemo
{
   public static void main(String[] args)
   {
      int[] a = ArrayUtil.randomIntArray(20, 100);
      System.out.println(Arrays.toString(a));

      InsertionSorter.sort(a);

      System.out.println(Arrays.toString(a));
   }
}
