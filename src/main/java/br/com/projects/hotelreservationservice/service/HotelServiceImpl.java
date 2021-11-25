package br.com.projects.hotelreservationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projects.hotelreservationservice.entity.Hotel;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel findById(Long theId) {		
		Optional<Hotel> result = hotelRepository.findById(theId);

		if(result.isPresent()) {
			return result.get();
		}else {
			//Hotel não encontrado
			throw new ErrorRegisterNotFoundInDataBase("Hotel com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Hotel save(Hotel theHotel) {
		// Caso o usuário envie um ID do frontend pelo JSON,
		// esse resguardo seta ele como 0, para o sistema forçar a entender como um novo
		// ao invés de fazer o update - Boas práticas!
		theHotel.setId(0L);
		return hotelRepository.save(theHotel);		
	}

	@Override
	public void deleteById(Long theId) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(theId);

		if(optionalHotel.isPresent()){
			hotelRepository.deleteById(theId);
		}else {		
			throw new ErrorRegisterNotFoundInDataBase("Hotel com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Hotel update(Hotel theHotel) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(theHotel.getId());

		if(optionalHotel.isPresent()){
			return hotelRepository.save(theHotel);
		}else{
			throw new ErrorRegisterNotFoundInDataBase("Hotel com Id " + theHotel.getId() + " não existe no banco de dados.");
		}
		
	}
    
}
