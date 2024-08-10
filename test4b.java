// merge 2 strings to form a new merged string
/* Append alternating characters from s1 and s2, respectively, to mergedString. Once all the characters
in one of the strings have been merged, append the remaining characters in the other string to
mergedString.
* */
import java.util.*;
import java.io.*;

public class test4b
{
    public static String mergeAlternately(String word1, String word2)
    {
        StringBuilder sb = new StringBuilder();
        int index1 = 0, index2 = 0;
        while(index1<word1.length() && index2<word2.length())
        {
            sb.append(word1.charAt(index1));
            sb.append(word2.charAt(index2));
            index1++;
            index2++;
        }
        while(index1<word1.length())
        {
            sb.append(word1.charAt(index1));
            index1++;
        }
        while(index2<word2.length())
        {
            sb.append(word2.charAt(index2));
            index2++;
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(mergeAlternately(s1,s2));
    }
}