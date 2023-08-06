package hac.repo;

import hac.entity.Citizen;
import hac.service.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    List<Citizen> findByDateOfBirthBetween(LocalDate startDate, LocalDate endDate);
    List<Citizen> findByCity(City city);
}
