// implementing fizzbuzz with 4 threads
/* divisible by 3 and 5 -> print fizzbuzz
   only divisible by 3 -> print fizz
   only divisible by 5 -> print buzz
   not divisible by 3 and 5 -> print that number
Threads :
 thread A -> calls fizz() -> checks if divisible by 3 -> outputs "fizz"
 thread B -> calls buzz() -> checks if divisible by 5 -> outputs "buzz"
 thread C -> calls fizzbuzz() -> checks if divisible by both 3 and 5 -> outputs "fizzbuzz"
 thread D -> calls number() -> should only output the numbers (not divisible by both 3 and 5)
print outputs up to n, starting from 1.
* */
import java.util.*;

public class test7b
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number(n) : ");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            if(i%3==0 && i%5==0)
            {
                Thread t = new Thread(new C());
                t.start();
                t.join();
            }
            else if(i%3==0)
            {
                Thread t = new Thread(new A());
                t.start();
                t.join();
            }
            else if(i%5==0)
            {
                Thread t = new Thread(new B());
                t.start();
                t.join();
            }
            else
            {
                Thread t = new Thread(new D(i));
                t.start();
                t.join();
            }
        }
    }
}

class A implements Runnable
{
    public void run()
    {
        System.out.print("fizz, ");
    }
}
class B implements Runnable
{
    public void run()
    {
        System.out.print("buzz, ");
    }
}
class C implements Runnable
{
    public void run()
    {
        System.out.print("fizzbuzz, ");
    }
}
class D implements Runnable
{
    private int number;
    public D(int number)
    {
        this.number = number;
    }
    public void run()
    {
        System.out.print(number+", ");
    }
}