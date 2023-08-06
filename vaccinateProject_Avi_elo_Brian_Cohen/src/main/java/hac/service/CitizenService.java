package hac.service;

import hac.entity.Citizen;
import hac.repo.CitizenRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional

public class CitizenService {

    private final CitizenRepository citizenRepository;

    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public Citizen registerCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public List<Citizen> getAllCitizens(LocalDate startDate, LocalDate endDate, City cityFilter) {
        return citizenRepository.findAll();
    }


    public List<Citizen> findUsersByDateOfBirthBetween(LocalDate start, LocalDate end) {
        return citizenRepository.findByDateOfBirthBetween(start, end);
    }

    public List<Citizen> findUsersByCity(City city) {
        return citizenRepository.findByCity(city);
    }
}
