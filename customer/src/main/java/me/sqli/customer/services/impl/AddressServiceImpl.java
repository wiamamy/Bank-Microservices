package me.sqli.customer.services.impl;

import org.springframework.stereotype.Service;

import me.sqli.customer.entities.Address;
import me.sqli.customer.repositories.AddressRepository;
import me.sqli.customer.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddressByAccountNo(Long accountNo) {
        return addressRepository.findById(accountNo).orElse(null);
    }

    public void updateAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(Long accountNo) {
        addressRepository.deleteById(accountNo);
    }
}
