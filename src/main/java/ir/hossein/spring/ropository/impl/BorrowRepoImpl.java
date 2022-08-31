package ir.hossein.spring.ropository.impl;

import ir.hossein.spring.entity.BookEntity;
import ir.hossein.spring.entity.BorrowEntity;
import ir.hossein.spring.ropository.BorrowRepo;
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
public class BorrowRepoImpl implements BorrowRepo {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<BorrowEntity> getBorrow() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<BorrowEntity> cq = cb.createQuery(BorrowEntity.class);
        Root< BorrowEntity > root = cq.from(BorrowEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveBorrow(BorrowEntity borrowEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(borrowEntity);
    }

    @Override
    public BorrowEntity getBorrow(int borrowId) {
        Session currentSession = sessionFactory.getCurrentSession();
        BorrowEntity borrowEntity = currentSession.get(BorrowEntity.class, borrowId);
        return borrowEntity;
    }

    @Override
    public void deleteBorrow(int borrowId) {
        Session session = sessionFactory.getCurrentSession();
        BorrowEntity borrowEntity = session.byId(BorrowEntity.class).load(borrowId);
        session.delete(borrowEntity);
    }
}
