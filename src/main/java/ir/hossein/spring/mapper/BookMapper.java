package ir.hossein.spring.mapper;

import ir.hossein.spring.entity.BookEntity;
import ir.hossein.spring.model.BookModel;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookEntity convertToEntity(BookModel bookModel);

    BookModel convertToModel(BookEntity bookEntity);

    List<BookModel> convertListToListModel(List<BookEntity> bookEntityList);

    List<BookEntity> convertListToListEntity(List<BookModel> bookModelList);

    default Long convertDateToLong(Date date) {
        return date != null ? date.getTime() : null;
    }

    default Date convertLongToDate(Long dateLong) {
        return dateLong != null ? new Date(dateLong) : null;
    }
}
