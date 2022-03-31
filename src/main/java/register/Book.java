package register;

public class Book
{
    public Book(String author,String title)
    {
        this.author=author;
        this.title=title;
    }
    public Book(String author,String title,String isbn)
    {
        this.author=author;
        this.title=title;
        this.isbn=isbn;
    }
    private String author;
    private String title;
    private String isbn;


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

    public void register(String isbn)
    {
        this.isbn=isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
