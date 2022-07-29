import java.util.Scanner;

public class Books {
    Book theBooks[] = new Book[50];
    public static int count;
    Scanner sc =new Scanner(System.in);

    public int compareBookObjects(Book b1, Book b2)
    {
        if(b1.bookName.equalsIgnoreCase(b2.bookName))
        {
            System.out.println("Book of this name is already exists");
            return 0;
        }
        if(b1.sNo == b2.sNo)
        {
            System.out.println("Book of this serial number is already exists");
            return 0;
        }
        return 1;
    }
    public void addBooks(Book b)
    {
        for(int i=0;i<count;i++) {
            if (this.compareBookObjects(b, this.theBooks[i]) == 0) {
                return;
            }
        }
        if (count < 50) {
            theBooks[count] = b;
            count++;
        }
        else
        {
            System.out.println("No space to add more books.");
        }
    }
    public void searchBysNo()
    {
        System.out.println("                   Search by serial Number :");
        System.out.println("Enter the serial number of Book that you want to be search");
        int sNo = sc.nextInt();
        int flag=0;
        for(int i=0;i<count;i++)
        {
            if(theBooks[i].sNo==sNo) {
                System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].totalbook + "\t\t"+ theBooks[i].bookqty);
                flag++;
                return;
            }
        }
        if(flag==0)
        {
            System.out.println("Book doesn't exists of "+ sNo + "this serial Number");
        }
    }
    public void searchBysAuthorName()
    {
        System.out.println("          Search by Author Name :");
        sc.nextLine();
        System.out.println("Enter the Author name of Book that you want to be search");
        String authorName = sc.nextLine();
        int flag=0;
        for(int i=0;i<count;i++)
        {
            if(authorName.equalsIgnoreCase(theBooks[i].authorName)) {
                System.out.println("Book exists!!");
                System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].totalbook + "\t\t"+ theBooks[i].bookqty);
                flag++;
                return;
            }
        }
        if(flag==0)
        {
            System.out.println(" No Books of " + authorName +" Found.");
        }
    }
    public void showAllBooks()
    {
        System.out.println("\t\t\t Showing All Books of Library\n");
        System.out.println("S.No\t\t Name\t\t Author\t\t Available Quantity\tTotalCount ");
        for(int i=0;i<count;i++)
        {
            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + theBooks[i].totalbook + "\t\t\t\t"+ theBooks[i].bookqty);

        }
    }
    public void updateBookQuantity()
    {
        System.out.println("UPDATE QUANTITY OF A BOOK");
        System.out.println("Enter serial number of book");
        int sNo = sc.nextInt();
        for(int i=0;i<count;i++)
        {
            if(sNo==theBooks[i].sNo) {
                System.out.println("Enter number of books to be added ");
                int n = sc.nextInt();
                theBooks[i].bookqty+=n;
                theBooks[i].totalbook+=n;
                return;
            }
        }
    }
    public void display()
    {
        System.out.println("*************************************************************************************\n");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Add New Book.");
        System.out.println("Press 2 to Update Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register a Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Books.");
        System.out.println("Press 8 to Check In Books.");
        System.out.println("************************************************************************************\n");
    }
    public int isAvailable(int sNo)
    {
        for(int i=0;i<count;i++)
        {
            if(theBooks[i].sNo==sNo)
            {
                if(theBooks[i].bookqty>0)
                {
                    System.out.println("Book is Available.");
                    return i;
                }
                System.out.println("Book is Not Available");
                return -1;
            }
        }
        System.out.println("No Book of Serial Number "+ sNo + " Available in Library.");
        return -1;
    }
    public Book checkOutBook()
    {
        System.out.println("Enter Serial Number of Book to be checked out");
        int sNo = sc.nextInt();
        int bookindex= isAvailable(sNo);
        if(bookindex!=-1)
        {
            theBooks[bookindex].totalbook--;
            return theBooks[bookindex];
        }
        return null;
    }
    public void checkInBook(Book book)
    {
        for(int i=0;i<count;i++)
        {
            if(book.equals(theBooks[i]))
            {
                theBooks[i].totalbook++;
                return;
            }
        }
    }
}
