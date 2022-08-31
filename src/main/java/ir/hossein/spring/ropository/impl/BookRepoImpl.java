package ir.hossein.spring.ropository.impl;

import ir.hossein.spring.entity.BookEntity;
import ir.hossein.spring.ropository.BookRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class BookRepoImpl implements BookRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<BookEntity> getBook() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<BookEntity> cq = cb.createQuery(BookEntity.class);
        Root< BookEntity > root = cq.from(BookEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveBook(BookEntity bookEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(bookEntity);
    }

    @Override
    public BookEntity getBook(int bookId) {
        Session currentSession = sessionFactory.getCurrentSession();
        BookEntity bookEntity = currentSession.get(BookEntity.class, bookId);
        return bookEntity;
    }

    @Override
    public void deleteBook(int bookId) {
        Session session = sessionFactory.getCurrentSession();
        BookEntity bookEntity = session.byId(BookEntity.class).load(bookId);
        session.delete(bookEntity);
    }
}
