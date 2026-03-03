package se.najeeb.library.Modell;

public class Book {
    private int loanId;
    private String author;
    private String title;
    private String type;
    private String category;

    private Book (){};

    public Book(int loanId, String author, String title, String type, String category) {
        this.loanId = loanId;
        this.author = author;
        this.title = title;
        this.type = type;
        this.category = category;
    }

    public Book(String author, String title, String type, String category) {
        this.author = author;
        this.title = title;
        this.type = type;
        this.category = category;
    }

    public int getLoanId() {
        return loanId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "loanId=" + loanId +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
