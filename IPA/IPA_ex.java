package IPA;
import java.util.*;

class Author{
    public int authorId;
    public String name;
    public Author(int authorId , String name){
        this.authorId = authorId;
        this.name = name;
    }

}

class Book {
    public int bookId;
    public String title , genre;
    public double price;
    public Author author;
    public Book(int bookId , String title , String genre , double price, Author author){
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.author = author;
    }
    public String getgenre(){
        return genre;
    }
    public String getname(){
        return author.name;
    }
    public String gettitle(){
        return title;
    }
    public double getprice(){
        return price;
    }
}

class Business {
    public static HashMap<String,String> getBooksBelongingToGenre(Book[] books , String disgenre){
        HashMap<String, String> hashMap = new HashMap<String,String>();
        for(int i = 0; i<books.length ; i++){
            if (books[i].getgenre().equalsIgnoreCase(disgenre)) {
                hashMap.put(books[i].getname(), books[i].gettitle());
            }
        }
        return hashMap;
    }
    public static Book[] getdiscountBooks(Book[] books , String getdis){
        
        int count = 0;
        for(int i = 0 ;i<books.length ; i++){
            if(books[i].getgenre().equalsIgnoreCase(getdis)){
                count++;
            }
        }
        if(count == 0){
            return null;
        }
        Book[] returnbooks = new Book[count]; 
        int j = 0;
        for(int i = 0 ; i<books.length ; i++){
            if(books[i].getgenre().equalsIgnoreCase(getdis)){
                returnbooks[j++] = books[i];
            }
        }
        
        return returnbooks;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int book_length = sc.nextInt(); 
        sc.nextLine();
        Book[] books = new Book[book_length];
        for(int i = 0 ; i<book_length ; i++){
            int authorId = sc.nextInt();
            sc.nextLine();
            String authorname = sc.nextLine();
            Author author = new Author(authorId, authorname);
            int bookId = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String genre = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            books[i] = new Book(bookId, title, genre, price, author);
        }
        String disgenre = sc.nextLine();
        String getdis = sc.nextLine();
        int disc_rate = sc.nextInt();
        sc.nextLine();
        HashMap <String , String> hsmp = getBooksBelongingToGenre(books,disgenre);
        if(hsmp.isEmpty()){
            System.out.println("There is no matching book");
        }
        else{
            hsmp.forEach((k,v) -> System.out.println("AuthorName: "+ k + "Title: " + v));
        }
        Book[] books2 = getdiscountBooks(books,getdis);
        if(books2 == null){
            System.out.println("Discounted books are unavailable in the given genre.");
        }
        else{
            System.out.println("Discounted" + getdis + "Books:");
            for(int i = 0 ; i<books2.length ; i++){
                double discount = books2[i].getprice()*(100 - disc_rate)/100;
                System.out.println("AuthorName:" + books2[i].getname() + ", Title: " + books2[i].gettitle() + "Updated Price :" + discount );
            }
        }
        sc.close();
    }
    
}





