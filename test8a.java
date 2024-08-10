// sorting employee list based on their experience (ascending order) - using ArrayList
import java.util.*;
class Employee
{
    String empname;
    int experience;
    Employee(String empname, int experience)
    {
        this.empname = empname;
        this.experience = experience;
    }
    public String toString()
    {
        return this.empname + " " + this.experience;
    }
}
class SortbyExperience implements Comparator<Employee>
{
    public int compare(Employee a, Employee b)
    {
        return a.experience-b.experience;
    }
}
class test8a
{
    public static void main(String[] args)
    {
        ArrayList<Employee> al = new ArrayList<Employee>();
        Employee e1 = new Employee("John",5);
        Employee e2 = new Employee("Nic",3);
        Employee e3 = new Employee("Rome",9);
        al.add(e1);
        al.add(e2);
        al.add(e3);
        System.out.println("Unsorted Employee List : ");
        for(int i=0;i<al.size();i++)
        {
            System.out.println(al.get(i).toString());
        }
        Collections.sort(al, new SortbyExperience());
        System.out.println("Sorted by Experience : ");
        for(int i=0;i<al.size();i++)
        {
            System.out.println(al.get(i).toString());
        }
    }
}