package com.training.spring.advanced.rest.mappers;

import com.training.spring.advanced.customer.services.models.Address;
import com.training.spring.advanced.customer.services.models.Customer;
import com.training.spring.advanced.customer.services.models.Phone;
import com.training.spring.advanced.rest.models.AddressRest;
import com.training.spring.advanced.rest.models.CustomerRest;
import com.training.spring.advanced.rest.models.PhoneRest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ICustomerMapper {

    ICustomerMapper MAPPER = Mappers.getMapper(ICustomerMapper.class);

    @Mapping(source = "phones",target = "phoneList")
    Customer toCustomer(CustomerRest customerRest);

    @Mapping(source = "phoneList",target = "phones")
    CustomerRest toCustomerRest(Customer customer);

    List<Customer> toCustomerList(List<CustomerRest> customerRest);

    List<CustomerRest> toCustomerRestList(List<Customer> customerRest);

    Address toAddress(AddressRest addressRest);

    AddressRest toAddressRest(Address address);

    Phone toPhone(PhoneRest phoneRest);

    PhoneRest toPhoneRest(Phone phone);


}
