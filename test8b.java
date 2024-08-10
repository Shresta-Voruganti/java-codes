/* Given a list of words and an integer k, find the top k most common words in the list, sorted in descending order
of their occurrence. If two or more words have the same occurrence, sort them in lexicographical order
(i.e., alphabetically).
The program reads input from the console: (Input Format) :
- The first line contains a list of words separated by spaces.
- The second line contains an integer k, which represents the number of top words to display.
Output Format: The program prints the top k most common words, separated by spaces.
* */
import java.util.*;

public class test8b
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String arr[] = s.split(" ");
        int k = sc.nextInt();
        int cnt = 0;
        Map<String,Integer> ch = new HashMap<String,Integer>();
        for(int i=0;i<arr.length;i++)
        {
            String x = arr[i];
            int c = ch.getOrDefault(x,0)+1;
            ch.put(x,c);
        }
        Map<String,Integer> ch1 = new TreeMap<String,Integer>(new Comparator<String>(){
            public int compare(String k1, String k2)
            {
                int cmp = ch.get(k2).compareTo(ch.get(k1));
                if(cmp==0)
                {
                    return k1.compareTo(k2);
                }
                else
                {
                    return cmp;
                }
            }
        });
        for(Map.Entry<String,Integer> l1 : ch.entrySet())
        {
            ch1.put(l1.getKey(),l1.getValue());
        }
        for(Map.Entry<String,Integer> l2 : ch1.entrySet())
        {
            System.out.print(l2.getKey() + " ");
            cnt++;
            if(cnt==k)
            {
                break;
            }
        }

    }
}