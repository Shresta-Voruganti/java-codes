/* You have a text file called "logfile" that contains survey results of favorite programming languages. Each line in the
file represents a single vote, with the following format:
    timestamp IP_address language
For example, the sample logfile has six entries:
    1643723400 192.168.1.100 PHP
    1643723405 192.168.1.100 PHP
    1643723410 128.120.56.214 PHP
    1643723420 192.168.1.100 C#
    1643723430 192.168.1.200 Prolog
    1643723440 192.168.1.100 PHP
Write a Java program to:
- Read the logfile and count the votes for each programming language.
- Ignore (or "throw out") any votes that come from the same IP address within 20 seconds of a previous vote for the same
language. This is to prevent people from voting multiple times for the same language.
- Display the final vote count for each language in a table, like this:
    PHP 2
    C# 1
    Prolog 1
Key Points:
- The logfile is ordered by increasing timestamp.
- You need to keep track of the timestamp and IP address for each vote to determine if a new vote is a duplicate.
- If a new vote is a duplicate (same language, same IP address, within 20 seconds of a previous vote), ignore it.
- Count the remaining votes for each language and display the results in a table.
Your Java program should:
- Read the logfile line by line
- Parse each line to extract the timestamp, IP address, and language
- Use a data structure (e.g., a HashMap) to keep track of the votes and timestamps for each language and IP address
- Implement the logic to ignore duplicate votes
- Display the final vote count for each language in a table
* */
import java.util.*;
import java.io.*;

class test6b
{
    public static void main(String[] args) throws Exception
    {
        FileReader fr = new FileReader("logfile.txt");
        BufferedReader br = new BufferedReader(fr);
        List<Data> al = new ArrayList<>();
        String line;
        while((line=br.readLine())!=null)
        {
            String data[] = line.split("\\s+");
            if(data.length>=3)
            {
                al.add(new Data(data[0], data[1], data[2]));
            }
            else
            {
                System.out.println("Invalid line : " + line);
            }
        }
        for(int i=0;i<al.size();i++)
        {
            for(int j=i+1;j<al.size();j++)
            {
                if(al.get(i).plang.equals(al.get(j).plang) && al.get(i).ip.equals(al.get(j).ip))
                {
                    al.remove(j--);
                }
            }
        }
        Map<String,Integer> votes = new HashMap<>();
        for(Data d : al)
        {
            int c = votes.getOrDefault(d.plang,0)+1;
            votes.put(d.plang,c);
        }
        for(Map.Entry<String,Integer> e : votes.entrySet())
        {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
class Data
{
    String plang,ip,id;
    Data(String plang, String ip, String id)
    {
        this.plang = plang;
        this.ip = ip;
        this.id = id;
    }
}