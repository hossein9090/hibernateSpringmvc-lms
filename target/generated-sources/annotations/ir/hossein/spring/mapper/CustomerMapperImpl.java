package ir.hossein.spring.mapper;

import ir.hossein.spring.entity.CustomerEntity;
import ir.hossein.spring.model.CustomerModel;
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
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity convertToEntity(CustomerModel customerModel) {
        if ( customerModel == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customerModel.getId() );
        customerEntity.setFirstName( customerModel.getFirstName() );
        customerEntity.setLastName( customerModel.getLastName() );
        customerEntity.setEmail( customerModel.getEmail() );

        return customerEntity;
    }

    @Override
    public CustomerModel convertToModel(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerModel customerModel = new CustomerModel();

        customerModel.setId( customerEntity.getId() );
        customerModel.setFirstName( customerEntity.getFirstName() );
        customerModel.setLastName( customerEntity.getLastName() );
        customerModel.setEmail( customerEntity.getEmail() );

        return customerModel;
    }

    @Override
    public List<CustomerModel> convertListToListModel(List<CustomerEntity> customerEntityList) {
        if ( customerEntityList == null ) {
            return null;
        }

        List<CustomerModel> list = new ArrayList<CustomerModel>( customerEntityList.size() );
        for ( CustomerEntity customerEntity : customerEntityList ) {
            list.add( convertToModel( customerEntity ) );
        }

        return list;
    }

    @Override
    public List<CustomerEntity> convertListToListEntity(List<CustomerModel> customerModelList) {
        if ( customerModelList == null ) {
            return null;
        }

        List<CustomerEntity> list = new ArrayList<CustomerEntity>( customerModelList.size() );
        for ( CustomerModel customerModel : customerModelList ) {
            list.add( convertToEntity( customerModel ) );
        }

        return list;
    }
}
