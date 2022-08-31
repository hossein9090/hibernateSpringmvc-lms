package ir.hossein.spring.mapper;

import ir.hossein.spring.entity.CustomerEntity;
import ir.hossein.spring.model.CustomerModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity convertToEntity(CustomerModel customerModel);

    CustomerModel convertToModel(CustomerEntity customerEntity);

    List<CustomerModel> convertListToListModel(List<CustomerEntity> customerEntityList);

    List<CustomerEntity> convertListToListEntity(List<CustomerModel> customerModelList);
}
