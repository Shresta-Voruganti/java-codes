// to check if a given number is gapful or not : if gapful : print "yes", else "no"

/* a number is gapful if, it is at least 3 digits long and is divisible by the number formed by stringing the first
and last numbers together.
* */
import java.util.*;

public class test1b
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        int l = s1.length();
        String s2 = s1.charAt(0)+""+s1.charAt(l-1);
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        if(l<3)
        {
            System.out.println("no");
        }
        else
        {
            if(n1%n2==0)
            {
                System.out.println("yes");
            }
            else
            {
                System.out.println("no");
            }
        }
    }
}