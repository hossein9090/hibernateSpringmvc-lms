package ir.hossein.spring.service;

import ir.hossein.spring.entity.BookEntity;
import ir.hossein.spring.model.BookModel;

import java.util.List;

public interface BookService {
    public List<BookModel> getBook();

    public void saveBook(BookModel bookModel);

    public BookModel getBook(int bookId);

    public void deleteBook(int bookId);
}
