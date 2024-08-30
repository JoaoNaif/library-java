import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Loan> loans;
    private List<Client> clients;

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void addBooks(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addAuthors(Author author){
        this.authors.add(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addLoans(Loan loan){
        this.loans.add(loan);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void addClients(Client client){
        this.clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Author findByNameAuthor(String name){
        for (Author author : authors) {
            if(author.getName().equals(name)){
                return author;
            }
        }
        return null;
    }

    public String listBooks() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books){
            if(book.getAvailable()){
                sb.append(book.getTitle()).append("(").append(book.getAuthor().getName()).append(")").append(" - ").append(book.getAvailable() ? "Disponível" : "Indisponível").append(" - id:").append(book.getId()).append("\n");
            }
        }
        return sb.toString();
    }

    public String findBook(String id, String email) {
        StringBuilder sb = new StringBuilder();
        for (Book book : books){
            if(book.getId().toString().equals(id)){
                sb.append(book.getId()).append(" - ").append(book.getTitle()).append(" - ").append(book.getAvailable() ? "Disponível\n" : "Indisponível\n");
                if(book.getAvailable()){
                    Client client = findByEmail(email);
                    Loan loan = new Loan(client.getId(), book.getId());
                    addLoans(loan);
                    book.setAvailable(false);
                    System.out.println("Livro adquirido" + book.getUpdatedAt());
                }else{
                    System.out.println("Livro Indisponível!");
                }
            }
        }
        return sb.toString();
    }

    public String listLoans() {
        StringBuilder sb = new StringBuilder();
        for (Book book : books){
            if(!book.getAvailable()){
                sb.append(book.getTitle()).append("(").append(book.getAuthor().getName()).append(")").append(" - ").append(book.getAvailable() ? "Disponível\n" : "Indisponível\n");
            }
        }
        return sb.toString();
    }

    public List<Loan> findManyLoans(Client client){
        List<Loan> findLoans = new ArrayList<>();
        for (Loan loan : loans){
            if(loan.clientId == client.getId()){
                findLoans.add(loan);
            }
        }
        return findLoans;
    }

    public Client findByEmail(String email){
        for(Client client : clients){
            if(client.getEmail().equals(email)){
                return client;
            }
        }
        return null;
    }

    public String listClients() {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (Client client : clients){
            sb.append(count).append(" - ").append(client.getName()).append(" - ").append(client.getEmail()).append("\n");
            count ++;
        }
        return sb.toString();
    }
}
