package com.janita.mock.one;

import com.janita.mock.one.bean.Book;
import com.janita.mock.one.service.BookService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Janita on 2017-04-18 19:54
 */
public class BookTest {

    private static BookService mockedBookService;
    private static Book book1;
    private static Book book2;

    @BeforeClass
    public static void setUp() throws Exception {
        mockedBookService = mock(BookService.class);
        // mock几个book实例
        book1 = new Book("ISBN1", "Java基础",
                Arrays.asList("葛嘉", "谌总"), "湘潭大学出版社",
                2008, 1009, "BOOK_ONE_IMAGE");

        book2 = new Book("ISBN2", "spring基础",
                Arrays.asList("刀哥"), "apache出版社", 2012, 675,
                "BOOK_TWO_IMAGE");

        // Stubbing the methods of mocked BookService with mocked data.
        when(mockedBookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
        when(mockedBookService.getBook("ISBN1")).thenReturn(book1);
        when(mockedBookService.addBook(book1)).thenReturn(book1.getIsbn());
        when(mockedBookService.updateBook(book1)).thenReturn(book1.getIsbn());

    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> allBooks = mockedBookService.getAllBooks();
        assertEquals(2, allBooks.size());
        Book myBook = allBooks.get(0);
        assertEquals("8131721019", myBook.getIsbn());
        assertEquals("Compilers Principles", myBook.getTitle());
        assertEquals(4, myBook.getAuthors().size());
        assertEquals((Integer) 2008, myBook.getYearOfPublication());
        assertEquals((Integer) 1009, myBook.getNumberOfPages());
        assertEquals("Pearson Education Singapore Pte Ltd",
                myBook.getPublication());
        assertEquals("BOOK_IMAGE", myBook.getImage());
    }

    @Test
    public void testGetBook() {

        String isbn = "ISBN1";
        Book myBook = mockedBookService.getBook(isbn);

        System.out.println("*******"+myBook);
        assertNotNull(myBook);
        assertEquals(isbn, myBook.getIsbn());
        assertEquals("Compilers Principles", myBook.getTitle());
        assertEquals(4, myBook.getAuthors().size());
        assertEquals("Pearson Education Singapore Pte Ltd",
                myBook.getPublication());
        assertEquals((Integer) 2008, myBook.getYearOfPublication());
        assertEquals((Integer) 1009, myBook.getNumberOfPages());

    }

    @Test
    public void testAddBook() {
        String isbn = mockedBookService.addBook(book1);
        assertNotNull(isbn);
        assertEquals(book1.getIsbn(), isbn);
    }

    @Test
    public void testUpdateBook() {

        String isbn = mockedBookService.updateBook(book1);
        assertNotNull(isbn);
        assertEquals(book1.getIsbn(), isbn);
    }
}
