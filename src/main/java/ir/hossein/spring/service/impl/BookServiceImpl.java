package ir.hossein.spring.service.impl;

import ir.hossein.spring.entity.BookEntity;
import ir.hossein.spring.mapper.BookMapper;
import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.ropository.BookRepo;
import ir.hossein.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookMapper bookMapper;

    @Override
    @Transactional
    public List<BookModel> getBook() {
        List<BookEntity> bookEntityList = bookRepo.getBook();
        return bookMapper.convertListToListModel(bookEntityList);
    }

    @Override
    @Transactional
    public void saveBook(BookModel bookModel) {
        BookEntity bookEntity = bookMapper.convertToEntity(bookModel);
        bookRepo.saveBook(bookEntity);
    }

    @Override
    @Transactional
    public BookModel getBook(int bookId) {
        BookEntity bookEntity = bookRepo.getBook(bookId);
        return bookMapper.convertToModel(bookEntity);
    }

    @Override
    @Transactional
    public void deleteBook(int bookId) {

        //TODO   change for adding bookMapper:

        bookRepo.deleteBook(bookId);
    }
}
