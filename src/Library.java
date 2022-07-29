import java.util.Scanner;

public class Library {


    public static void main(String[]args)
    {
        Scanner sc= new Scanner(System.in);

        System.out.println("********************Welcome to the College Library!********************");
        System.out.println("                  Select From The Following Options:               ");
        System.out.println("**********************************************************************");

        Books books= new Books();
        Students st =new Students();
        int ch;
        char ch1;
        do {
            books.display();
            ch=sc.nextInt();
            switch (ch)
            {
                case 1 :
                    Book book =new Book();
                    books.addBooks(book);
                    break;

                case 2 :
                    books.updateBookQuantity();
                    break;

                case 3 :
                    System.out.println("Enter 'A' for search with Author Name ");
                    System.out.println("Enter 'B' for seach with serial Number of Book");
                    ch1 = sc.next().charAt(0);
                    switch(ch1)
                    {
                        case 'A' :
                            books.searchBysAuthorName();
                            break;

                        case 'B' :
                            books.searchBysNo();
                            break;
                    }

                case 4:
                    books.showAllBooks();
                    break;

                case 5:
                    Student s =new Student();
                    st.addStudents(s);
                    break;

                case 6:
                    st.showAllStudents();
                    break;

                case 7 :
                    st.checkOutBook(books);
                    break;

                case 8 :
                    st.checkInBook(books);
                    break;

                default:
                    System.out.println(" please enter a valid choice ");
            }
        }while(ch!=0);

    }
}
