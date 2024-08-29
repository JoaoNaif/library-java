import java.time.LocalDate;
import java.util.UUID;

public class Book {
    private final UUID id;
    private String title;
    private final Author author;
    private Boolean available;
    private final LocalDate createdAt;
    private LocalDate updatedAt;

    public Book(String title, Author author){
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.available = true;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    public UUID getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Boolean getAvailable() {
        touch();
        return available;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    private void touch(){
        this.updatedAt = LocalDate.now();
    }
}
