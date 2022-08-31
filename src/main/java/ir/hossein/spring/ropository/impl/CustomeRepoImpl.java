package ir.hossein.spring.ropository.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ir.hossein.spring.ropository.CustomerRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ir.hossein.spring.entity.CustomerEntity;

@Repository
public class CustomeRepoImpl implements CustomerRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <CustomerEntity> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery <CustomerEntity> cq = cb.createQuery(CustomerEntity.class);
        Root <CustomerEntity> root = cq.from(CustomerEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        CustomerEntity book = session.byId(CustomerEntity.class).load(id);
        session.delete(book);
    }

    @Override
    public void saveCustomer(CustomerEntity theCustomerEntity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomerEntity);
    }

    @Override
    public CustomerEntity getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        CustomerEntity theCustomerEntity = currentSession.get(CustomerEntity.class, theId);
        return theCustomerEntity;
    }
}