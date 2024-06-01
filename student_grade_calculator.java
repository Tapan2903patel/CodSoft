import java.util.Scanner;

public class student_grade_calculator
{
    public static int totalMarks(int arr[])
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }
    public static String getGrade(int avg)
    {
        if(avg>=80)
        {
            return "A";
        }
        else if(avg>=60 && avg<80)
        {
            return "B";
        }
        else if(avg>=40 && avg<60)
        {
            return "C";
        }
        else
        {
            return "D";
        }
    }
    public static void print_details(String name,int marks[], int total,int avg,String grade)
    {
        System.out.println("\nName :"+name);
        System.out.println("| Subjects || Marks |");
        System.out.println("_____________________");
        System.out.println("| Physics  || "+marks[0]+"    |");
        System.out.println("| Chemistry|| "+marks[1]+"    |");
        System.out.println("| Maths    || "+marks[2]+"    |");
        System.out.println("| English  || "+marks[3]+"    |");
        System.out.println("| Computer || "+marks[4]+"    |");

        System.out.println("\nTotal Obtained marks(out of 500) :"+total);
        System.out.println("Average Percentage :"+avg+" %");
        System.out.println("Grade :"+grade);



    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Full name:");
        String name=sc.nextLine();

        System.out.println("Please Enter the Obtained Marks(out of 100) of the " +
                "\n\t\tPhysics, \n\t\tChemistry, \n\t\tMaths, " +
                "\n\t\tEnglish, \n\t\tComputer \nrespectively");


        int marks[]=new int[5];
        for(int i=0;i<5;i++)
        {
            marks[i]=sc.nextInt();
        }
        sc.close();

        int total=totalMarks(marks);
        int avg=total/5;
        String grade=getGrade(avg);

        print_details(name,marks,total,avg,grade);


    }
}
