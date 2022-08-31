package ir.hossein.spring.entity;

import javax.persistence.*;


@Entity
@Table(name = "borrow")
public class BorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customerId")
    private int customerId;

    @Column(name = "bookId")
    private int bookId;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id",insertable = false,updatable = false)
    private BookEntity bookByBookId;
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id",insertable = false,updatable = false)
    private CustomerEntity customerByCustomerId;

    public BorrowEntity(int id, int customerId, int bookId, BookEntity bookByBookId, CustomerEntity customerByCustomerId) {
        this.id = id;
        this.customerId = customerId;
        this.bookId = bookId;
        this.bookByBookId = bookByBookId;
        this.customerByCustomerId = customerByCustomerId;
    }

    public BorrowEntity(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
