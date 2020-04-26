package arkham.knight.covid.repositories;

import arkham.knight.covid.models.CoronaVirus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaVirusRepository extends JpaRepository<CoronaVirus, Long> {

    CoronaVirus findByCountry(String country);
}
