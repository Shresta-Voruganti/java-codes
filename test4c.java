// find magical decimal representation of a given string as per  shown keypad.
/* Output : decimal representation corresponding to string
     1      2(abc)   3(def)
   4(ghi)   5(jkl)   6(mno)             :  keypad
   7(pqrs)  8(tuv)   9(wxyz)
     *        0        []

if given string : "amazon" -> decimal representation : "262966" (output)
* */
import java.util.*;
import java.io.*;

public class test4c
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] c = new char[s.length()];
        for(int i=0;i<s.length();i++)
        {
            c[i] = s.charAt(i);
            switch(c[i])
            {
                case 'a':
                case 'b':
                case 'c':
                    System.out.print("2");
                    break;
                case 'd':
                case 'e':
                case 'f':
                    System.out.print("3");
                    break;
                case 'g':
                case 'h':
                case 'i':
                    System.out.print("4");
                    break;
                case 'j':
                case 'k':
                case 'l':
                    System.out.print("5");
                    break;
                case 'm':
                case 'n':
                case 'o':
                    System.out.print("6");
                    break;
                case 'p':
                case 'q':
                case 'r':
                case 's':
                    System.out.print("7");
                    break;
                case 't':
                case 'u':
                case 'v':
                    System.out.print("8");
                    break;
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    System.out.print("9");
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
