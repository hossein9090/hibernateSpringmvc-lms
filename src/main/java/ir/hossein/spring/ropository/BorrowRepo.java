package ir.hossein.spring.ropository;

import ir.hossein.spring.entity.BorrowEntity;

import java.util.List;

public interface BorrowRepo {

    public List<BorrowEntity> getBorrow();

    public void saveBorrow(BorrowEntity borrowEntity);

    public BorrowEntity getBorrow(int borrowId);

    public void deleteBorrow(int borrowId);
}
