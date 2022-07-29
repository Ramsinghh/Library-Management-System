import java.util.Scanner;

public class Student {
    Scanner sc = new Scanner(System.in);
    String studentName;
    int rollNo;
    Book borrowedBook[]=new Book[5];
    public int booksCount=0;
    public Student()
    {
        System.out.println("Enter Name of Student ");
        this.studentName = sc.nextLine();
        System.out.println("Enter RollNo of Student ");
        this.rollNo = sc.nextInt();
    }
}
