package ir.hossein.spring.mapper;

import ir.hossein.spring.entity.BorrowEntity;
import ir.hossein.spring.model.BorrowModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BorrowMapper {

    BorrowEntity convertToEntity(BorrowModel borrowModel);

    BorrowModel convertToModel(BorrowEntity borrowEntity);

    List<BorrowModel> convertListToListModel(List<BorrowEntity> borrowEntityList);

    List<BorrowEntity> convertListToListEntity(List<BorrowModel> borrowModelList);
}
