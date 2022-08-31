package ir.hossein.spring.mapper;

import ir.hossein.spring.entity.BorrowEntity;
import ir.hossein.spring.model.BorrowModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-31T16:56:06+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0-262 (OpenLogic-OpenJDK)"
)
@Component
public class BorrowMapperImpl implements BorrowMapper {

    @Override
    public BorrowEntity convertToEntity(BorrowModel borrowModel) {
        if ( borrowModel == null ) {
            return null;
        }

        BorrowEntity borrowEntity = new BorrowEntity();

        borrowEntity.setId( borrowModel.getId() );
        borrowEntity.setCustomerId( borrowModel.getCustomerId() );
        borrowEntity.setBookId( borrowModel.getBookId() );

        return borrowEntity;
    }

    @Override
    public BorrowModel convertToModel(BorrowEntity borrowEntity) {
        if ( borrowEntity == null ) {
            return null;
        }

        BorrowModel borrowModel = new BorrowModel();

        borrowModel.setId( borrowEntity.getId() );
        borrowModel.setCustomerId( borrowEntity.getCustomerId() );
        borrowModel.setBookId( borrowEntity.getBookId() );

        return borrowModel;
    }

    @Override
    public List<BorrowModel> convertListToListModel(List<BorrowEntity> borrowEntityList) {
        if ( borrowEntityList == null ) {
            return null;
        }

        List<BorrowModel> list = new ArrayList<BorrowModel>( borrowEntityList.size() );
        for ( BorrowEntity borrowEntity : borrowEntityList ) {
            list.add( convertToModel( borrowEntity ) );
        }

        return list;
    }

    @Override
    public List<BorrowEntity> convertListToListEntity(List<BorrowModel> borrowModelList) {
        if ( borrowModelList == null ) {
            return null;
        }

        List<BorrowEntity> list = new ArrayList<BorrowEntity>( borrowModelList.size() );
        for ( BorrowModel borrowModel : borrowModelList ) {
            list.add( convertToEntity( borrowModel ) );
        }

        return list;
    }
}
