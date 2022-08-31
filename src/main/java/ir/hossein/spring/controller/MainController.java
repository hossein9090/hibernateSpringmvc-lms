package ir.hossein.spring.controller;


import java.util.List;

import ir.hossein.spring.entity.BookEntity;
import ir.hossein.spring.entity.BorrowEntity;
import ir.hossein.spring.entity.CustomerEntity;
import ir.hossein.spring.model.BookModel;
import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.model.CustomerModel;
import ir.hossein.spring.service.BookService;
import ir.hossein.spring.service.BorrowService;
import ir.hossein.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/customer")
public class MainController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List <CustomerModel> theCustomerEntities = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomerEntities);
        return "list-customers";
    }

    @GetMapping("/bookList")
    public String listBooks(Model theModel) {
        List <BookModel> theBooks = bookService.getBook();
        theModel.addAttribute("theBooks", theBooks);
        return "list-books";
    }

    @GetMapping("/borrowList")
    public String listBorrow(Model theModel) {
        List <BorrowModel> theBorrow = borrowService.getBorrow();
        theModel.addAttribute("theBorrows", theBorrow);
        return "list-borrow";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        CustomerModel theCustomerEntity = new CustomerModel();
        theModel.addAttribute("customer", theCustomerEntity);
        return "customer-form";
    }

    @GetMapping("/showBookForm")
    public String showBookFormForAdd(Model theModel) {
        BookModel theBook = new BookModel();
        theModel.addAttribute("book", theBook);
        return "book-form";
    }

    @GetMapping("/showBorrowForm")
    public String showBorrowFormForAdd(Model theModel) {
        BorrowModel theBorrow = new BorrowModel();
        theModel.addAttribute("borrow", theBorrow);
        return "borrow-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") CustomerModel theCustomerModel) {
        customerService.saveCustomer(theCustomerModel);
        return "redirect:/list";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") BookModel theBook) {
        bookService.saveBook(theBook);
        return "redirect:/bookList";
    }

    @PostMapping("/saveBorrow")
    public String saveBorrow(@ModelAttribute("borrow") BorrowModel theBorrow) {
        borrowService.saveBorrow(theBorrow);
        return "redirect:/borrowList";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
        CustomerModel theCustomerEntity = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomerEntity);
        return "customer-form";
    }

    @GetMapping("/updateBookForm")
    public String showBookFormForUpdate(@RequestParam("bookId") int bookId,Model theModel) {
        BookModel theBook = bookService.getBook(bookId);
        theModel.addAttribute("book", theBook);
        return "book-form";
    }

    @GetMapping("/updateBorrowForm")
    public String showBorrowFormForUpdate(@RequestParam("borrowId") int borrowId,Model theModel) {
        BorrowModel theBorrow = borrowService.getBorrow(borrowId);
        theModel.addAttribute("borrow", theBorrow);
        return "borrow-form";
    }


    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);
        return "redirect:/list";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/bookList";
    }

    @GetMapping("/deleteBorrow")
    public String deleteBorrow(@RequestParam("borrowId") int borrowId) {
        borrowService.deleteBorrow(borrowId);
        return "redirect:/borrowList";
    }
}
