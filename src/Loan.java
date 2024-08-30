import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Loan {
    UUID id;
    UUID clientId;
    UUID bookId;
    LocalDate CreatedAt;

    public Loan(UUID clientId, UUID bookId){
        this.clientId = clientId;
        this.bookId = bookId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getBookId() {
        return bookId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public LocalDate getCreatedAt() {
        return CreatedAt;
    }
}
