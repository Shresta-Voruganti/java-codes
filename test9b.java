/* calculating the number of common key-value pairs from 2 HashMaps by using method
        commonKeyValuePairs(HashMap<String,String> map1, HashMap<String,String> map2);
 */
import java.util.*;

public class test9b
{
    public static int commonKeyValuePairs(HashMap<String,String> map1, HashMap<String,String> map2)
    {
        int count = 0;
        for(Map.Entry m1 : map1.entrySet())
        {
            for(Map.Entry m2 : map2.entrySet())
            {
                if(m1.getKey().equals(m2.getKey()) && m1.getValue().equals(m2.getValue()))
                {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> map1 = new HashMap<String,String>();
        HashMap<String,String> map2 = new HashMap<String,String>();
        System.out.println("Enter how many key-value pairs in HashMap1 : ");
        int n1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter " + n1 + " pairs of strings: ");
        for(int i=0;i<n1;i++)
        {
            String pairs[] = sc.nextLine().split(" ");
            map1.put(pairs[0], pairs[1]);
        }
        System.out.println("Enter how many key-value pairs in HashMap2 : ");
        int n2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter " + n2 + " pairs of strings: ");
        for(int i=0;i<n2;i++)
        {
            String pairs[] = sc.nextLine().split(" ");
            map2.put(pairs[0], pairs[1]);
        }
        int count = commonKeyValuePairs(map1, map2);
        System.out.println("Number of common key-value pairs : " + count);
    }
}