package ir.hossein.spring.ropository;

import ir.hossein.spring.entity.BookEntity;

import java.util.List;

public interface BookRepo {

    public List<BookEntity> getBook();

    public void saveBook(BookEntity bookEntity);

    public BookEntity getBook(int bookId);

    public void deleteBook(int bookId);

}
