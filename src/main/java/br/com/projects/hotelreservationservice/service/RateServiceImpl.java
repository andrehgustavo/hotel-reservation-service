package br.com.projects.hotelreservationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projects.hotelreservationservice.entity.Rate;
import br.com.projects.hotelreservationservice.exception.ErrorRegisterNotFoundInDataBase;
import br.com.projects.hotelreservationservice.repository.RateRepository;

@Service
public class RateServiceImpl implements RateService{

    @Autowired
    private RateRepository RateRepository;

    @Override
	public List<Rate> findAll() {
		return RateRepository.findAll();
	}

	@Override
	public Rate findById(Long theId) {		
		Optional<Rate> result = RateRepository.findById(theId);

		if(result.isPresent()) {
			return result.get();
		}else {
			//Rate não encontrado
			throw new ErrorRegisterNotFoundInDataBase("Rate com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Rate save(Rate theRate) {
		// Caso o usuário envie um ID do frontend pelo JSON,
		// esse resguardo seta ele como 0, para o sistema forçar a entender como um novo
		// ao invés de fazer o update - Boas práticas!
		theRate.setId(0L);
		return RateRepository.save(theRate);		
	}

	@Override
	public void deleteById(Long theId) {
		Optional<Rate> optionalRate = RateRepository.findById(theId);

		if(optionalRate.isPresent()){
			RateRepository.deleteById(theId);
		}else {		
			throw new ErrorRegisterNotFoundInDataBase("Rate com Id " + theId + " não existe no banco de dados.");
		}
	}

	@Override
	public Rate update(Rate theRate) {
		Optional<Rate> optionalRate = RateRepository.findById(theRate.getId());

		if(optionalRate.isPresent()){
			return RateRepository.save(theRate);
		}else{
			throw new ErrorRegisterNotFoundInDataBase("Rate com Id " + theRate.getId() + " não existe no banco de dados.");
		}
		
	}
    
}
