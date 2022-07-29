import java.util.Scanner;

public class Book {
        Scanner sc = new Scanner(System.in);
        int sNo;
        String bookName;
        String authorName;
        int bookqty;
        int totalbook;
        public Book()
        {
            System.out.println("Enter serial number of Book:");
            this.sNo = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Book Name:");
            this.bookName = sc.nextLine();
            System.out.println("Enter author Name:");
            this.authorName = sc.nextLine();
            System.out.println("Enter quantity of books:");
            this.bookqty = sc.nextInt();
            totalbook = this.bookqty;
        }
}
