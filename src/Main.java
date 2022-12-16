import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.impl.BookServiceImpl;
import service.impl.UserServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.


        Book book1 = new Book(1L, "Omur", Genre.HISTORICAL, BigDecimal.valueOf(250), "Abdishukur Narmatov", Language.KYRGYZ, LocalDate.of(2015, 12, 25));
        Book book2 = new Book(2L, "Adam adebi", Genre.HISTORICAL, BigDecimal.valueOf(350), "Abdishukur Narmatov", Language.KYRGYZ, LocalDate.of(2017, 12, 25));
        Book book3 = new Book(3L, "Beiish jolu", Genre.HISTORICAL, BigDecimal.valueOf(290), "Abdishukur Narmatov", Language.KYRGYZ, LocalDate.of(2016, 12, 25));

        User user1 = new User(1L, "Alisher", "Nurmatov", "alisher00@gmail.com", "+996700700700", Gender.MALE, BigDecimal.valueOf(1200), new ArrayList<>());
        User user2 = new User(2L, "Bakyt", "Baiysh uulu", "bakyt00@gmail.com", "+996500700700", Gender.MALE, BigDecimal.valueOf(2200), new ArrayList<>());
        User user3 = new User(3L, "Shirin", "Alymova", "shirin00@gmail.com", "+996200700700", Gender.FEMALE, BigDecimal.valueOf(3200), new ArrayList<>());

        List<User> users = new ArrayList<>(List.of(user1, user2, user3));
        List<Book> books = new ArrayList<>(List.of(book1, book2, book3));

        BookServiceImpl bookService = new BookServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        while (true) {
            System.out.println("Enter a command from 0 to 14: ");
            int command = new Scanner(System.in).nextInt();
            if (command == 0) break;
            if (command == 1) System.out.println(bookService.createBooks(books));
            if (command == 2) System.out.println(bookService.getAllBooks());
            if (command == 3) System.out.println(bookService.getBooksByGenre("Historical"));
            if (command == 4) System.out.println(bookService.removeBookById(1L));
            if (command == 5) System.out.println(bookService.maxPriceBook());
            if (command == 6) System.out.println(bookService.getBookByInitialLetter());
            if (command == 7) System.out.println(bookService.sortBooksByPriceInDescendingOrder());
            if (command == 8) System.out.println(bookService.filterBooksByPublishedYear());

            if (command == 9) System.out.println(userService.createUser(users));
            if (command == 10) System.out.println(userService.findAllUsers());
            if (command == 11) System.out.println(userService.findUserById(2L));
            if (command == 12) System.out.println(userService.removeUserByName("Bakyt"));
            if (command == 13) userService.groupUsersByGender();
            if (command == 14) userService.updateUser(1L);
            if (command == 15) System.out.println(userService.buyBooks("Bakyt", books));

        }

    }
}