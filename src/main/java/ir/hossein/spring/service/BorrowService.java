package ir.hossein.spring.service;

import ir.hossein.spring.entity.BorrowEntity;
import ir.hossein.spring.model.BorrowModel;

import java.util.List;

public interface BorrowService {

    public List<BorrowModel> getBorrow();

    public void saveBorrow(BorrowModel borrowModel);

    public BorrowModel getBorrow(int borrowId);

    public void deleteBorrow(int borrowId);
}
