//Library Management System 
//futures, Add new Book., Upgrade Quantity of a Book., Search a Book., Show All Books.,Register Student., Show All Registered Students., Check Out Book., Check In Book.. 

import java.util.Scanner;
public class book {
public int sNo;
public String bookName;
public String authorName;
public int bookQty;
public int bookQtyCopy;

    
public book(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Serial No of Book:\n");
    sNo = input.nextInt();
    input.nextLine();
    System.out.println("Enter Book Name:\n");
    bookName = input.nextLine();
    System.out.println("Enter Author Name:\n");
    authorName = input.nextLine();
    System.out.println("Enter Quantity of Books:\n");
    bookQty = input.nextInt();
    bookQtyCopy = bookQty;
}
}
public class books {
book theBooks[] = new book[50];     // Array that stores 'book' Objects.
    int count;                // Counter for No of book objects Added in Array.
Scanner input = new Scanner(System.in);
public int compareBookObjects(book b1, book b2){

    if (b1.bookName.equalsIgnoreCase(b2.bookName)){

        System.out.println("Book of this Name Already Exists.\n");
        return 0;

    }
    if (b1.sNo==b2.sNo){

        System.out.println("Book of this Serial No Already Exists.\n");
        return 0;
    }
    return 1;
}

public void addBook(book b){

    for (int i=0; i<count; i++){

        if (this.compareBookObjects(b, this.theBooks[i]) == 0)
            return;

    }

    if (count<50){

        theBooks[count] = b;
        count++;

    }
    else{

        System.out.println("No Space to Add More Books.\n");

    }

}

public void searchBySno(){

    System.out.println(" SEARCH BY SERIAL NUMBER\n ");

    int sNo;
    System.out.println("Enter Serial No of Book:\n");
    sNo = input.nextInt();

    int flag = 0;
    System.out.println("S.No , Name , Author , Available Qty , Total Qty\n");
    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){

            System.out.println(theBooks[i].sNo + ", " + theBooks[i].bookName + ", " + theBooks[i].authorName + ", " + 
                theBooks[i].bookQtyCopy + ", " + theBooks[i].bookQty);
            flag++;
            return;
          }
    }
    if (flag == 0)
        System.out.println("No Book for Serial No " + sNo + " Found.\n");
    }

public void searchByAuthorName(){
    System.out.println("SEARCH BY AUTHOR'S NAME\n");
    input.nextLine();
    System.out.println("Enter Author Name:\n");
    String authorName = input.nextLine();
    int flag = 0;
    System.out.println("S.No , Name , Author , Available Qty , Total Qty\n");
    for (int i=0; i<count; i++){

        if (authorName.equalsIgnoreCase(theBooks[i].authorName)){

            System.out.println(theBooks[i].sNo + ", " + theBooks[i].bookName + ", " + theBooks[i].authorName + ",  " + 
                theBooks[i].bookQtyCopy + ", " + theBooks[i].bookQty);
            flag++;
        }
    }
    if (flag == 0)
        System.out.println("No Books of " + authorName + " Found.\n");
}
public void showAllBooks(){
     System.out.println(" SHOWING ALL BOOKS\n");
     System.out.println("S.No , Name , Author , Available Qty , Total Qty\n");
    for (int i=0; i<count; i++){

        System.out.println(theBooks[i].sNo + ", " + theBooks[i].bookName + ", " + theBooks[i].authorName + ", " + 
                theBooks[i].bookQtyCopy + ", " + theBooks[i].bookQty);
   }
}
public void upgradeBookQty(){
     System.out.println("UPGRADE QUANTITY OF A BOOK\n");
     System.out.println("Enter Serial No of Book.\n");
     int sNo = input.nextInt();
     for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){

            System.out.println("Enter No of Books to be Added:\n");
            int addingQty = input.nextInt();
            theBooks[i].bookQty += addingQty;
            theBooks[i].bookQtyCopy += addingQty;
            return;
           }
        }
    }
public void dispMenu(){
    System.out.println("----------------------------------------------------------------------------------------------------------");
    System.out.println("Enter 0 to Exit Application.\n");
    System.out.println("Enter 1 to Add new Book.\n");
    System.out.println("Enter 2 to Upgrade Quantity of a Book.\n");
    System.out.println("Enter 3 to Search a Book.\n");
    System.out.println("Enter 4 to Show All Books.\n");
    System.out.println("Enter 5 to Register Student.\n");
    System.out.println("Enter 6 to Show All Registered Students.\n");
    System.out.println("Enter 7 to Check Out Book. \n");
    System.out.println("Enter 8 to Check In Book.\n");
    System.out.println("-------------------------------------------------------------------------------------------------------");
}
public int isAvailable(int sNo){
    
    for (int i=0; i<count; i++){
        if (sNo == theBooks[i].sNo){
            if(theBooks[i].bookQtyCopy > 0){
                System.out.println("Book is Available.\n");
                return i;
                }
            System.out.println("Book is Unavailable.\n");
            return -1;
        }
    }
        System.out.println("No Book of Serial Number " + " Available in Library.\n");
        return -1;
}
public book checkOutBook(){

    System.out.println("Enter Serial No of Book to be Checked Out.\n");
    int sNo = input.nextInt();

    int bookIndex =isAvailable(sNo);

    if (bookIndex!=-1){

        theBooks[bookIndex].bookQtyCopy--;

        return theBooks[bookIndex];
    }

    return null;

}
public void checkInBook(book b){

    for (int i=0; i<count; i++){

        if (b.equals(theBooks[i]) ){

            theBooks[i].bookQtyCopy++;
            return;
        }
    }
}
}
public class student{
private String studentName;
public String regNum;
book borrowedBooks[] = new book[3];
public int booksCount = 0;
Scanner input = new Scanner(System.in);
public void setname(String name){
    studentName = name;
}
public String getname(){
    return studentName;
}
public student(){

    System.out.println("Enter Student Name:");
    String name = input.nextLine();

    System.out.println("Enter Reg Number:");
      regNum = input.nextLine();
}
}

public class students extends books {
Scanner input = new Scanner(System.in);

student theStudents[] = new student[50];
public static int count = 0;
public void addStudent(student s){
    for (int i=0; i<count; i++){

        if(s.regNum.equalsIgnoreCase(theStudents[i].regNum)){

            System.out.println("Student of Reg Num " + s.regNum + " is Already Registered.\n");
            return;
        }

    }

    if (count<=50){

        theStudents[count] = s;
        count++;

    }

}
public void showAllStudents(){

    System.out.println("Student Name  ,  Reg Number. \n");
    for (int i=0; i<count; i++){

        System.out.println(theStudents[i].getname() + " " + theStudents[i].regNum);

    }


}

public int isStudent(){
    System.out.println("Enter Reg Number:\n");
    String regNum = input.nextLine();

    for (int i=0; i<count; i++){

        if (theStudents[i].regNum.equalsIgnoreCase(regNum)){

            return i;
        }
    }
    System.out.println("Student is not Registered.\n");
    System.out.println("Get Registered First.\n");
    
    return -1;
}
public void checkOutBook(books book){
    int studentIndex = isStudent();

    if (studentIndex!=-1){
        System.out.println("checking out\n");

        book.showAllBooks();
        book b = book.checkOutBook();
        System.out.println("checking out\n");
        if (b!= null){

            if (theStudents[studentIndex].booksCount<=3){
                System.out.println("adding book\n");
                theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
                theStudents[studentIndex].booksCount++;
                return;

            }
            else {

                System.out.println("Student Can not Borrow more than 3 Books.\n");
                return;

            }
        }
        System.out.println("Book is not Available.\n");

    }

}

public void checkInBook(books book){

    int studentIndex = isStudent();
    if (studentIndex != -1){
        System.out.println("S.No , Book Name , Author Name\n");
        student s = theStudents[studentIndex];
        for (int i=0; i<s.booksCount; i++){

            System.out.println(s.borrowedBooks[i].sNo+ " " + s.borrowedBooks[i].bookName + " "+
                    s.borrowedBooks[i].authorName);

        }
        System.out.println("Enter Serial Number of Book to be Checked In:\n");
        int sNo = input.nextInt();
        for (int i=0; i<s.booksCount; i++){

            if (sNo == s.borrowedBooks[i].sNo){

                book.checkInBook(s.borrowedBooks[i]);
                s.borrowedBooks[i]=null;
                return;
            }
        }
        System.out.println("Book of Serial No "+sNo+"not Found.\n");
    }
}
}
public class Library {
public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("************WELCOME TO THE LIBRARY!**********\n");
    System.out.println("        Please Select From The Following Options:        \n");
    students ob = new students();
    int choice;
    int searchChoice;

    do{

        ob.dispMenu();
        choice = input.nextInt();

        switch(choice){

            case 1:
                book b = new book();
                ob.addBook(b);
                break;

            case 2:
                ob.upgradeBookQty();
                break;

            case 3:
                System.out.println("Enter 1 to Search with Serial No.\n");
                System.out.println("Enter 2 to Search with Author Name(Full Name).\n");
                searchChoice = input.nextInt();

                switch(searchChoice){

                    case 1:
                        ob.searchBySno();
                        break;
                    case 2:
                        ob.searchByAuthorName();

                }
                break;

            case 4:
                ob.showAllBooks();
                break;
            case 5:
                student s = new student();
                ob.addStudent(s);
                break;
            case 6:
                ob.showAllStudents();
                break;
            case 7:
                ob.checkOutBook(ob);
                break;
            case 8:
                ob.checkInBook(ob);
                break;
            default:
                System.out.println("CHOICE SHOULD BE BETWEEN 0 TO 8.\n");
        }
    }
    while (choice!=0);
}
}
 
















