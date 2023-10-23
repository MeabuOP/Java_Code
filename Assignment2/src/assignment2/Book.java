package assignment2;

public class Book implements Comparable<Book>{
    String ISBN;
    String bookTitle;
    String bookAuthor;
    String yearOfPublication;
    String publisher;
    String imageURLM;
    String imageURLL;

    public Book(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Book(String ISBN, String bookTitle, String bookAuthor, String yearOfPublication, String publisher, String imageURLM, String imageURLL) {
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
        this.imageURLM = imageURLM;
        this.imageURLL = imageURLL;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageURLM() {
        return imageURLM;
    }

    public void setImageURLM(String imageURLM) {
        this.imageURLM = imageURLM;
    }

    public String getImageURLL() {
        return imageURLL;
    }

    public void setImageURLL(String imageURLL) {
        this.imageURLL = imageURLL;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "ISBN='" + ISBN + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ";bookAuthor='" + bookAuthor + '\'' +
                ", yearOfPublication='" + yearOfPublication + '\'' +
                ", publisher='" + publisher + '\'' +
                ", imageURLL='" + imageURLL + '\'' +
                ", imageURLM='" + imageURLM + '\'';
    }

    @Override
    public int compareTo(Book o) {
        return this.bookTitle.compareTo(o.getBookTitle());
    }

}
