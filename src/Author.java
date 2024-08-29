import java.time.LocalDate;
import java.util.UUID;

public class Author {
    private final UUID id;
    private String name;
    private LocalDate birthday;

    public Author(String name, LocalDate birthday){
        this.id = UUID.randomUUID();
        this.name = name;
        this.birthday = birthday;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
