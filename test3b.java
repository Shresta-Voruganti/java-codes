// print pattern into a square matrix
/* right(forward) -> down(forward) -> left(reverse) -> up(reverse) (looping fashion)
input  = 5
output =
    1      2     3     4    5
    16    17    18    19    6
    15    24    25    20    7
    14    23    22    21    8
    13    12    11    10    9
* */
import java.util.*;

public class test3b
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = n-1;
        int colEnd = n-1;
        while(rowBegin<=rowEnd && colBegin<=colEnd)
        {
            //traverse right
            for(int j=colBegin;j<=colEnd;j++)
            {
                a[rowBegin][j] = sc.nextInt();
            }
            rowBegin++;

            //traverse down
            for(int i=rowBegin;i<=rowEnd;i++)
            {
                a[i][colEnd] = sc.nextInt();
            }
            colEnd--;

            //traverse left
            if(colBegin<=colEnd)
            {
                for(int j=colEnd;j>=colBegin;j--)
                {
                    a[rowEnd][j] = sc.nextInt();
                }
            }
            rowEnd--;

            //traverse up
            if(rowBegin<=rowEnd)
            {
                for(int i=rowEnd;i>=rowBegin;i--)
                {
                    a[i][colBegin] = sc.nextInt();
                }
            }
            colBegin++;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}