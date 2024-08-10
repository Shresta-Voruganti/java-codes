/*  implement a method Addition() that returns a new Array where each
array element at the index k corresponds to the sum of elements of the array (src) starting at
index 0 and including element at the index ‘k’. For an array of size ‘0’ or a null parameter, the method will throw
exception IllegalArgumentExceptionWith the message “Invalid Argument”
For example, for array [2,3,5], the method will return array [2,5,10]
* */
import java.util.*;

public class test7a
{
    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter size of the array : ");
       int n = sc.nextInt();
       int arr[];
       try
       {
           if(n>0)
           {
               arr = new int[n];
           }
           else
           {
                throw new IllegalArgumentException();
           }
           System.out.println("Enter elements into the array : ");
           for(int i=0;i<n;i++)
           {
               arr[i] = sc.nextInt();
           }
           test7a rs = new test7a();
           int resultarr[] = rs.addition(arr);
           System.out.println(Arrays.toString(resultarr));
       }
       catch(IllegalArgumentException e)
       {
           System.out.println("Invalid Argument");
       }
    }

    int[] addition(int[] a)
    {
        int sum = 0;
        for(int i=0;i<a.length;i++)
        {
            a[i]+=sum;
            sum = a[i];
        }
        return a;
    }
}