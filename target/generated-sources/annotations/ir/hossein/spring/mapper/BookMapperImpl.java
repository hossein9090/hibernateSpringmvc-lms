package ir.hossein.spring.mapper;

import ir.hossein.spring.entity.BookEntity;
import ir.hossein.spring.model.BookModel;
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
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity convertToEntity(BookModel bookModel) {
        if ( bookModel == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId( bookModel.getId() );
        bookEntity.setName( bookModel.getName() );
        bookEntity.setAuthorName( bookModel.getAuthorName() );

        return bookEntity;
    }

    @Override
    public BookModel convertToModel(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookModel bookModel = new BookModel();

        bookModel.setId( bookEntity.getId() );
        bookModel.setName( bookEntity.getName() );
        bookModel.setAuthorName( bookEntity.getAuthorName() );

        return bookModel;
    }

    @Override
    public List<BookModel> convertListToListModel(List<BookEntity> bookEntityList) {
        if ( bookEntityList == null ) {
            return null;
        }

        List<BookModel> list = new ArrayList<BookModel>( bookEntityList.size() );
        for ( BookEntity bookEntity : bookEntityList ) {
            list.add( convertToModel( bookEntity ) );
        }

        return list;
    }

    @Override
    public List<BookEntity> convertListToListEntity(List<BookModel> bookModelList) {
        if ( bookModelList == null ) {
            return null;
        }

        List<BookEntity> list = new ArrayList<BookEntity>( bookModelList.size() );
        for ( BookModel bookModel : bookModelList ) {
            list.add( convertToEntity( bookModel ) );
        }

        return list;
    }
}
