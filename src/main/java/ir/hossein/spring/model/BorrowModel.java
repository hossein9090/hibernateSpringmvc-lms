package ir.hossein.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class BorrowModel {

    private int id;
    private int customerId;
    private int bookId;

    public BorrowModel(int id, int customerId, int bookId) {
        this.id = id;
        this.customerId = customerId;
        this.bookId = bookId;
    }
    public BorrowModel(){
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
}
