import org.example.DigitalLibraryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DigitalLibraryTest {
    static DigitalLibraryImpl lib;
    @BeforeAll
    public static void starter(){
        lib = new DigitalLibraryImpl();
    }
    @Test
    public void checkIfAddBookAddsBook(){
        //Arrange
        String book = "Knyga";
        //Act
        lib.addBook(book);
        //Assert
        Assertions.assertTrue(lib.getAllBooks().contains(book));

    }
    @Test
    public void checkIfSearchBooksFindsABook(){
        //Arrange
        String query = "knyg";
        String book = "knyga";
        String book1 = "knyga1";
        String book2 = "test";
        List<String> testList = new ArrayList<>();
        testList.add(book);
        testList.add(book1);
        lib.addBook(book);
        lib.addBook(book1);
        lib.addBook(book2);
        //Act
        List<String> l = lib.searchBooks(query);
        //Assert
        Assertions.assertIterableEquals(testList, l);
    }
    @Test
    public void checkIfGetBookCountReturnsCorrectSize(){
        //Arrange
        String s = "s";
        lib.addBook(s);
        lib.addBook(s);
        lib.addBook(s);
        //Act
        int count = lib.getBookCount();
        //Assert
        Assertions.assertEquals(3, count);
    }
    @Test
    public void checkIsBookAvailable(){
        //Arrange
        String title = "Knyga";
        lib.addBook(title);
        //Act&Assert
        Assertions.assertTrue(lib.isBookAvailable(title));
    }
    @Test
    public void checkIfUpdateBookTitleUpdatesBookAndReturnsTrue(){
        //Arrange
        String oldTitle = "Knyga";
        lib.addBook(oldTitle);
        String newTitle = "Nauja Knyga";
        String book = null;

        //Act
        boolean b = lib.updateBookTitle(oldTitle, newTitle);
        for(String s : lib.searchBooks(newTitle)){
            book = s;
            break;
        }
        //Assert
        Assertions.assertTrue(b);
        Assertions.assertEquals(book, newTitle);
    }
}
