package br.com.projects.hotelreservationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projects.hotelreservationservice.entity.Address;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address findById(Long theId) {		
		Optional<Address> result = addressRepository.findById(theId);

		if(result.isPresent()) {
			return result.get();
		}else {
			//Address não encontrado
			throw new ErrorRegisterNotFoundInDataBase("Endereço com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Address save(Address theAddress) {

		theAddress.setId(0L);
		return addressRepository.save(theAddress);		
	}

	@Override
	public void deleteById(Long theId) {
		Optional<Address> optionalAddress = addressRepository.findById(theId);

		if(optionalAddress.isPresent()){
			addressRepository.deleteById(theId);
		}else {		
			throw new ErrorRegisterNotFoundInDataBase("Endereço com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Address update(Address theAddress) {
		Optional<Address> optionalAddress = addressRepository.findById(theAddress.getId());

		if(optionalAddress.isPresent()){
			return addressRepository.save(theAddress);
		}else{
			throw new ErrorRegisterNotFoundInDataBase("Endereço com Id " + theAddress.getId() + " não existe no banco de dados.");
		}
		
	}
    
}
