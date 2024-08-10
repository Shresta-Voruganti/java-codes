// cricket pension calculation
/* india, test>10 & odi>100 -> 50,000
   india, test>10 -> 25,000
   india, odi>100 -> 15,000
   only india -> 10,000
   man of match -> increment by 1/4th
   india(no), ipl(yes) -> 8,000
   man of match -> increment by 1/4th
   india(no), ipl(no) -> 7,000
**/
import java.util.*;

public class test1c
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Has he played for india?");
        char c1 = sc.next().charAt(0);
        System.out.println("Has he played for ipl?");
        char c2 = sc.next().charAt(0);
        float amount = 0.0f;
        if(c1=='y')
        {
            System.out.println("Enter no. of test matches played:");
            int test = sc.nextInt();
            System.out.println("Enter no. of odi matches played:");
            int odi = sc.nextInt();
            System.out.println("Enter no. of man of the match awards won (test,odi):");
            int mom = sc.nextInt();
            if(test>10 && odi>100)
            {
                amount+=50000;
            }
            else if(test>10)
            {
                amount+=25000;
            }
            else if(odi>100)
            {
                amount+=15000;
            }
            else
            {
                amount+=10000;
            }
            amount+=amount*0.25f*mom;
            System.out.println(amount);
//            System.exit(100);
        }
        if(c2=='y')
        {
            System.out.println("Enter no. of man of the match awards won in ipl:");
            int mom1 = sc.nextInt();
            amount+=8000;
            amount+=amount*0.25f*mom1;
            System.out.println(amount);
//            System.exit(100);
        }
        if(c1!='y' && c2!='y')
        {
            amount+=7000;
            System.out.println(amount);
            System.exit(100);
        }
    }
}