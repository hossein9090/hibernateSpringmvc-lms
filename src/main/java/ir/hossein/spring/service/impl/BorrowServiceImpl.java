package ir.hossein.spring.service.impl;

import ir.hossein.spring.entity.BorrowEntity;
import ir.hossein.spring.mapper.BorrowMapper;
import ir.hossein.spring.model.BorrowModel;
import ir.hossein.spring.ropository.BorrowRepo;
import ir.hossein.spring.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;

    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    @Transactional
    public List<BorrowModel> getBorrow() {
        List<BorrowEntity> borrowEntityList = borrowRepo.getBorrow();
        List<BorrowModel> borrowModels = borrowMapper.convertListToListModel(borrowEntityList);
        return borrowModels;

    }

    @Override
    @Transactional
    public void saveBorrow(BorrowModel borrowModel) {
        BorrowEntity borrowEntity = borrowMapper.convertToEntity(borrowModel);
        borrowRepo.saveBorrow(borrowEntity);
    }

    @Override
    @Transactional
    public BorrowModel getBorrow(int borrowId) {
        BorrowEntity borrowEntity = borrowRepo.getBorrow(borrowId);
        BorrowModel borrowModel = borrowMapper.convertToModel(borrowEntity);
        return borrowModel;
    }

    @Override
    @Transactional
    public void deleteBorrow(int borrowId) {

        //TODO   change for adding borrowMapper:

        borrowRepo.deleteBorrow(borrowId);
    }
}
