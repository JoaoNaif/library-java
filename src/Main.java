import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    int op;
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int op;

        do{
            System.out.println("\nMenu Inicial\n1-Adicionar um livro\n2-Listar livros\n3-Pegar livro emprestado\n4-Registrar Cliente\n5-Listar Clientes\n6-Listar Empréstimos\n7-Sair ");
            System.out.print("O que deseja fazer: ");
            op = scanner.nextInt();

            switch (op){
                case 1:
                    System.out.print("\nQual o nome do autor: ");
                    Scanner scannerNameAuthor = new Scanner(System.in);
                    String nameAuthor = scannerNameAuthor.nextLine();

                    Author author = library.findByNameAuthor(nameAuthor);

                    if(author != null){
                        System.out.print("\nQual o título do livro: ");
                        Scanner scannerTitleBook = new Scanner(System.in);
                        String titleBook = scannerTitleBook.nextLine();

                        Book book = new Book(titleBook, author);
                        library.addBooks(book);
                    }else {
                        System.out.print("\nQual a data de nascimento do autor: ");
                        Scanner scannerDateAuthor = new Scanner(System.in);
                        String dateAuthor = scannerNameAuthor.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate date = LocalDate.parse(dateAuthor, formatter);

                        Author newAuthor = new Author(nameAuthor, date);
                        library.addAuthors(newAuthor);

                        System.out.print("\nQual o título do livro: ");
                        Scanner scannerTitle = new Scanner(System.in);
                        String titleBook = scannerTitle.nextLine();

                        Book book = new Book(titleBook, newAuthor);
                        library.addBooks(book);
                    }
                    System.out.println("Novo livro adicionado!");
                    break;
                case 2:
                    System.out.println("Livros da biblioteca:\n");
                    System.out.println(library.listBooks());
                    break;
                case 3:
                    System.out.println(library.listBooks());
                    System.out.println("Qual livro adquirir?\n");
                    System.out.print("Id do livro: ");
                    Scanner scannerNum = new Scanner(System.in);
                    String id = scannerNum.nextLine();
                    System.out.print("Seu e-mail registrado: ");
                    Scanner scannerEmail = new Scanner(System.in);
                    String email = scannerEmail.nextLine();
                    System.out.println(library.findBook(id, email));
                    break;
                case 4:
                    System.out.print("Digite seu e-mail: ");
                    Scanner scannerCreateEmail = new Scanner(System.in);
                    String emailCreate = scannerCreateEmail.nextLine();
                    System.out.print("Digite seu nome: ");
                    Scanner scannerCreateName = new Scanner(System.in);
                    String nameCreate = scannerCreateName.nextLine();
                    Client client = new Client(emailCreate, nameCreate);
                    library.addClients(client);
                    break;
                case 5:
                    System.out.println("Clientes registrados:\n");
                    System.out.println(library.listClients());
                    break;
                case 6:
                    System.out.println("Livros emprestados:\n");
                    System.out.println(library.listLoans());
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while (op != 7);
    }
}