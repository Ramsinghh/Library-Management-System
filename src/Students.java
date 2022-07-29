import java.util.Scanner;

public class Students {
    Scanner sc = new Scanner(System.in);
    Student theStudents[] = new Student[50];
    Student st =new Student();
    public static int count=0;

    public void addStudents(Student s) {
        for (int i = 0; i < count; i++) {
            if (s.rollNo == theStudents[i].rollNo) {
                System.out.println("Student of Rollno = " + s.rollNo + " Already Exists!!");
                return;
            }
        }
        if (count < 50) {
            theStudents[count] = s;
            count++;

        }
    }
    public void showAllStudents()
    {
        System.out.println("Student Name\t\t Student RollNo");
        for(int i=0;i<count;i++)
        {
            System.out.println(theStudents[i].studentName + theStudents[i].rollNo);
        }
    }
    public int isStudent()
    {
        System.out.println("Enter RollNo of Student");
        int rollNo = sc.nextInt();
        for(int i=0;i<count;i++)
        {
            if(rollNo ==theStudents[i].rollNo)
            {
                return i;
            }
        }
        System.out.println("Student Not Found of this RollNo");
        return -1;
    }
    public void checkOutBook(Books books)
    {
        int index = this.isStudent();
        if(index!=-1)
        {
            System.out.println("Checking Out...");
            books.showAllBooks();
            Book book = books.checkOutBook();
            System.out.println("Checking Out...");
            if(book!=null)
            {
                if(theStudents[index].booksCount<=5)
                {
                    System.out.println("adding books...");
                    theStudents[index].borrowedBook[theStudents[index].booksCount] = book;
                    theStudents[index].booksCount++;

                    return;
                }
                else {
                    System.out.println("You can not borrow more then 5 books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }
    public void checkInBook(Books books)
    {
        int index = this.isStudent();
        if(index!=-1) {
            System.out.println("S.No \t\t  Book Name\t\t\tAuthor Name");
            Student s = theStudents[index];
            for (int i = 0; i < s.booksCount; i++) {
                System.out.println(s.borrowedBook[i].sNo + "\t\t\t" + s.borrowedBook[i].bookName + "\t\t\t"+ s.borrowedBook[i].authorName);
            }
            System.out.println("Enter serial number of book");
            int sNo=sc.nextInt();
            for (int i=0;i<s.booksCount;i++)
            {
                if(sNo==s.borrowedBook[i].sNo)
                {
                    books.checkInBook(s.borrowedBook[i]);
                    s.borrowedBook[i]=null;
                    return;
                }
            }
            System.out.println("Book of Serial No " + sNo + " not Found");
        }
    }
}
